package br.senai.sp.jandira.gamesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.withStyledAttributes
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.gamesapplication.adapter.GamesAdapter
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAccountBinding
import br.senai.sp.jandira.gamesapplication.model.Usuario
import br.senai.sp.jandira.gamesapplication.repository.GamesRepository
import br.senai.sp.jandira.gamesapplication.repository.UsuarioRepository

class AccountActivity : AppCompatActivity() {

    lateinit var binding: ActivityAccountBinding
    lateinit var repository: GamesRepository
    lateinit var adapter: GamesAdapter
    lateinit var user: Usuario
    lateinit var userRepository: UsuarioRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        supportActionBar!!.hide()

        userRepository = UsuarioRepository(this)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener{
            val open = Intent(this, AddGame::class.java)
            startActivity(open)
        }

        val id = intent.getIntExtra("id", 0 )
        loadProfile(id)
    }

    private fun loadProfile(id: Int) {
        user = userRepository.getUsuarioById(id)
        binding.textViewName.text = user.nome
        binding.textViewEmail.text = user.email
        binding.textGamesFinish.text = "0"
        binding.textCurrentPlaying.text = "0"
        binding.textAge.text = user.dataNascimento
        binding.textViewLevelAccount.text = user.nivel.toString()
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