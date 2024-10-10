package com.example.mvvmsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val firstNameTextView: TextView = view.findViewById(R.id.firstNameTextView)
        val lastNameTextView: TextView = view.findViewById(R.id.lastNameTextView)
        val emailTextView: TextView = view.findViewById(R.id.emailTextView)
        val avatarImageView: ImageView = view.findViewById(R.id.avatarImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.firstNameTextView.text = user.first_name
        holder.lastNameTextView.text = user.last_name
        holder.emailTextView.text = user.email

        // Load avatar image using Glide
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .into(holder.avatarImageView)
    }

    override fun getItemCount() = users.size
}
