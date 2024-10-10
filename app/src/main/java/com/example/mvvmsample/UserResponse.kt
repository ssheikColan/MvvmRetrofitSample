package com.example.mvvmsample

data class UserResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<User>,    // List of User objects
    val support: Support     // Support information
)

