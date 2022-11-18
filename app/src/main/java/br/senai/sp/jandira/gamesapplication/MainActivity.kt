package br.senai.sp.jandira.gamesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.textViewCreateAccount.setOnClickListener {
            val openSingUpActivity =
                Intent(this, SingUpActivity::class.java)
            startActivity(openSingUpActivity)
        }

        binding.buttonLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        if(validar()){
            val email = binding.editTextTextEmailAddress.text.toString()
            val senha = binding.editTextTextPassword.text.toString()

            //Abrir o BANCO DE DADOS

        }
    }

    private fun validar(): Boolean {
        if(binding.editTextTextEmailAddress.text.isEmpty()){
            binding.editTextTextEmailAddress.error = "E-mail is required!"
            return false
        }

        if (binding.editTextTextPassword.text.isEmpty()){
            binding.editTextTextPassword.error = "Password is required!"
            return false
        }
        return true
    }


}