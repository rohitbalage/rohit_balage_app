package com.rrbofficial.rohitbalage.ui.github

data class GithubUser(
    val login: String,
    val name: String?,
    val avatar_url: String,
    val bio: String?,
    val public_repos: Int,
    val followers: Int,
    val following: Int,
    val company: String?,
    val location: String?,
    val email: String?,
    val twitter_username: String?,
    val hireable: Boolean?,
    val updated_at: String?
)