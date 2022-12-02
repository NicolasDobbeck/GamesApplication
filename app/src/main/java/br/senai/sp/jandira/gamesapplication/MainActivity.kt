package br.senai.sp.jandira.gamesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.databinding.ActivityMainBinding
import br.senai.sp.jandira.gamesapplication.model.Usuario
import br.senai.sp.jandira.gamesapplication.repository.UsuarioRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userRepository: UsuarioRepository
//    private lateinit var user: Usuario

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

    private fun login(): Boolean {
        if(validar()){
            val email = binding.editTextEmailAddress.text.toString()
            userRepository = UsuarioRepository(this)
            val user = userRepository.getUsuarioByEmail(email)

            if (user === null){
                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                return false
            }
            else if (user.senha != binding.editTextTextPassword.text.toString()){
                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                return false
            }else{
                val openAccountActivity = Intent(this, AccountActivity::class.java)
                openAccountActivity.putExtra("id", user.id)
                startActivity(openAccountActivity)
            }

        }
        return true
    }

    private fun validar(): Boolean {
        if(binding.editTextEmailAddress.text.isEmpty()){
            binding.editTextEmailAddress.error = "E-mail is required!"
            return false
        }

        if (binding.editTextTextPassword.text.isEmpty()){
            binding.editTextTextPassword.error = "Password is required!"
            return false
        }
        return true
    }


}