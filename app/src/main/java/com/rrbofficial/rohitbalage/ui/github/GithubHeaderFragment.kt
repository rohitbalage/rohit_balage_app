package com.rrbofficial.rohitbalage.ui.github

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.gson.GsonBuilder
import com.rrbofficial.rohitbalage.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

// Retrofit API interface
interface GithubApi {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): GithubUser
}

class GithubHeaderFragment : Fragment() {

    private val githubUser = "rohitbalage" // Your GitHub username
    private lateinit var api: GithubApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Logging interceptor to log raw JSON
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(GithubApi::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_github_header, container, false)

        val profilePic = view.findViewById<ImageView>(R.id.github_profile_pic)
        val name = view.findViewById<TextView>(R.id.github_name)
        val username = view.findViewById<TextView>(R.id.github_username)
        val bio = view.findViewById<TextView>(R.id.github_bio)
        val repos = view.findViewById<TextView>(R.id.github_repos)
        val followers = view.findViewById<TextView>(R.id.github_followers)
        val following = view.findViewById<TextView>(R.id.github_following)
        val company = view.findViewById<TextView>(R.id.github_company)
        val location = view.findViewById<TextView>(R.id.github_location)
        val email = view.findViewById<TextView>(R.id.github_email)
        val twitter = view.findViewById<TextView>(R.id.x_twitter)
        val hireable = view.findViewById<TextView>(R.id.github_hireable)
        val updatedAt = view.findViewById<TextView>(R.id.github_updated_at)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val user = api.getUser(githubUser)

                // Log parsed object
                Log.d("GITHUB_RESPONSE", user.toString())

                // Log pretty JSON
                val gson = GsonBuilder().setPrettyPrinting().create()
                Log.d("GITHUB_RESPONSE_JSON", gson.toJson(user))

                withContext(Dispatchers.Main) {
                    name.text = user.name ?: "No Name"
                    username.text = "@${user.login}"
                    bio.text = user.bio ?: "No bio available"
                    repos.text = "Repos: ${user.public_repos}"
                    followers.text = "Followers: ${user.followers}"
                    following.text = "Following: ${user.following}"
                    company.text = user.company ?: "No company info"
                    location.text = user.location ?: "No location info"
                    email.text = user.email ?: "No email"
                    twitter.text = user.twitter_username?.let { "@$it" } ?: "No Twitter"
                    hireable.text = if (user.hireable == true) "Yes" else "No"
                    updatedAt.text = user.updated_at ?: "No update info"

                    Glide.with(requireContext())
                        .load(user.avatar_url)
                        .into(profilePic)
                }
            } catch (e: Exception) {
                Log.e("GITHUB_RESPONSE", "Error fetching user", e)
            }
        }

        return view
    }
}
