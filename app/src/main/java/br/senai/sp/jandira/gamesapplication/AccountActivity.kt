package br.senai.sp.jandira.gamesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.gamesapplication.adapter.GamesAdapter
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAccountBinding
import br.senai.sp.jandira.gamesapplication.repository.GamesRepository

class AccountActivity : AppCompatActivity() {

    lateinit var binding: ActivityAccountBinding
    lateinit var repository: GamesRepository
    lateinit var adapter: GamesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        supportActionBar!!.hide()

        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onResume() {
        super.onResume()
        carregarRecyclerView()
    }

    private fun carregarRecyclerView() {

        repository = GamesRepository(this)

        val contacts = repository.getAll()
        adapter = GamesAdapter(contacts, this)
        binding.rvGames.adapter = adapter

        binding.rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}