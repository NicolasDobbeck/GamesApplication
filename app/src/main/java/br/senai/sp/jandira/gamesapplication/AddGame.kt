package br.senai.sp.jandira.gamesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.gamesapplication.databinding.ActivityAddGameBinding
import br.senai.sp.jandira.gamesapplication.databinding.ActivitySingUpBinding
import br.senai.sp.jandira.gamesapplication.repository.GamesRepository

class AddGame : AppCompatActivity() {
    private lateinit var binding: ActivityAddGameBinding
    private lateinit var gamesRepository: GamesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)

        supportActionBar!!.hide()
        binding = ActivityAddGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSaveAdd.setOnClickListener {
            val save = Intent(this, AccountActivity::class.java)
            startActivity(save)
        }
        validar()
    }



    private fun validar():Boolean {
        if(binding.editTextNameGame.text.isEmpty()){
            binding.editTextNameGame.error = "Please fill in the mandatory fields"
            return false
        }
        if(binding.editTextAddDescr.text.isEmpty()){
            binding.editTextAddDescr.error = "Please fill in the mandatory fields"
            return false
        }
        if(binding.editTextAddStudio.text.isEmpty()){
            binding.editTextAddStudio.error = "Please fill in the mandatory fields"
            return false
        }
        if(binding.editTextAddDate.text.isEmpty()){
            binding.editTextAddDate.error = "Please fill in the mandatory fields"
            return false
        }
        return true
    }
}