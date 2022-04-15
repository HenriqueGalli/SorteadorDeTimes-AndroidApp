package com.project.sorteador_nomes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SortedTeamsActivity : AppCompatActivity() {

    private var nameList = arrayListOf<String>()
    private lateinit var teamAList: MutableList<String>
    private lateinit var teamBList: MutableList<String>

    private lateinit var rvTeamA: RecyclerView
    private lateinit var rvTeamB: RecyclerView
    private lateinit var btnSortNewTeam: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorted_teams)

        if (intent.hasExtra("NAMES_LIST")) {
            nameList = intent.extras?.getStringArrayList("NAMES_LIST") as ArrayList<String>
            bindView()
            setupTeams(nameList)
            setupAdapters(teamAList, teamBList)
            setupListeners()
        }
    }

    private fun setupListeners() {
        btnSortNewTeam.setOnClickListener {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun bindView() {
        rvTeamA = findViewById(R.id.rv_team_a)
        rvTeamB = findViewById(R.id.rv_team_b)
        btnSortNewTeam = findViewById(R.id.btn_sort_new_team)
    }

    private fun setupAdapters(teamAList: MutableList<String>, teamBList: MutableList<String>) {
        val adapterTeamA = SortedTeamAdapter(teamAList)
        val adapterTeamB = SortedTeamAdapter(teamBList)

        val layoutManagerTeamA = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val layoutManagerTeamB = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvTeamA.layoutManager = layoutManagerTeamA
        rvTeamB.layoutManager = layoutManagerTeamB

        rvTeamA.adapter = adapterTeamA
        rvTeamB.adapter = adapterTeamB
    }

    private fun setupTeams(nameList: java.util.ArrayList<String>) {
        nameList.shuffle()
        teamAList = nameList.subList(0, nameList.size / 2)
        teamBList = nameList.subList(nameList.size / 2, nameList.size)
    }
}