package com.project.sorteador_nomes

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var nameList = arrayListOf<String>()

    private lateinit var etName: EditText
    private lateinit var fabAddName: FloatingActionButton
    private lateinit var btnSortTeams: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        setupListeners()
    }

    private fun bindView() {
        etName = findViewById(R.id.et_name)
        fabAddName = findViewById(R.id.fab_add_name)
        btnSortTeams = findViewById(R.id.btn_sort_teams)
    }

    private fun setupListeners() {
       fabAddName.setOnClickListener {
           if(etName.text.isNotBlank()){
               addNameOnList()
               hideKeyboard()
           }
       }
       btnSortTeams.setOnClickListener{
           if(!nameList.isNullOrEmpty()){
               sortTeams()
           }
       }
    }

    private fun sortTeams() {
        val intent = Intent(this, SortedTeamsActivity::class.java)
        intent.putExtra("NAMES_LIST", nameList)
        startActivity(intent)
    }

    private fun addNameOnList() {
        nameList.add(etName.text.toString())
        Toast.makeText(this,etName.text.toString()+" adicionado na lista!",Toast.LENGTH_LONG).show()
        etName.text.clear()
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }


}