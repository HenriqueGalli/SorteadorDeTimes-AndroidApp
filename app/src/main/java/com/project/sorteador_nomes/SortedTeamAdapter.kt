package com.project.sorteador_nomes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SortedTeamAdapter(private val team: List<String>) :
    RecyclerView.Adapter<SortedTeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sorted_name, parent, false)
        return TeamViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(team[position])
    }

    override fun getItemCount() = team.size

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName = itemView.findViewById<TextView>(R.id.tv_sorted_name)
        fun bind(name: String) {
            tvName.text = name
        }

    }
}