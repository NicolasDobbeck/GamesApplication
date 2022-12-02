package br.senai.sp.jandira.gamesapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.senai.sp.jandira.gamesapplication.databinding.ActivitySingUpBinding
import br.senai.sp.jandira.gamesapplication.model.NiveisEnum
import br.senai.sp.jandira.gamesapplication.model.Usuario
import br.senai.sp.jandira.gamesapplication.repository.UsuarioRepository

class SingUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingUpBinding
    private lateinit var userRepository: UsuarioRepository
    private lateinit var slider: UsuarioRepository
    lateinit var user: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()
        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewSave.setOnClickListener {
            if (userData()){
                val open = Intent(this, MainActivity::class.java)
                startActivity(open)
            }
        }

        binding.sliderLevel.addOnChangeListener{ slider, value, clebin ->
            binding.textViewLevel.text = gamerLevel(value.toInt())!!.level
        }

    }


    private fun userData(): Boolean{
        if(validar()){
            user = Usuario()
            user.email = binding.editTextEmail.text.toString()
            user.senha = binding.editTextPassword.text.toString()
            user.nome = binding.editTextName.text.toString()
            user.cidade = binding.editTextCity.text.toString()
            user.dataNascimento = binding.editTextBirthDate.text.toString()

            userRepository = UsuarioRepository(this)
            val id = userRepository.save(user)
            Toast.makeText(this, "ID: $id", Toast.LENGTH_LONG).show()

            return true
        }
        return false
    }

    //Fun para selecionar o level do usuário
    private fun gamerLevel(value: Int): NiveisEnum{
        if (value == 1){
            return NiveisEnum.INICIANTE
        }
        if (value == 2){
            return NiveisEnum.BASICO
        }
        if (value == 3){
            return NiveisEnum.CASUAL
        }
            return NiveisEnum.AVANCADO
    }

    // Salva os dados do usuário
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.text_view_save){
            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    //Chama o menu criado anteriormente
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        //infla o menu que ele me passou no meu layout
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

    //Valida os campos de cadastro de usuário
    private fun validar(): Boolean{
        if(binding.editTextEmail.text.isEmpty()){
            binding.editTextEmail.error = "Please fill in the mandatory fields"
            return false
        }
        if(binding.editTextPassword.text.isEmpty()){
            binding.editTextPassword.error = "Please fill in the mandatory fields"
            return false
        }
        if(binding.editTextName.text.isEmpty()){
            binding.editTextName.error = "Please fill in the mandatory fields"
            return false
        }
        if(binding.editTextCity.text.isEmpty()){
            binding.editTextCity.error = "Please fill in the mandatory fields"
            return false
        }
        if(binding.editTextBirthDate.text.isEmpty()){
            binding.editTextBirthDate.error = "Please fill in the mandatory fields"
            return false
        }
        return true
    }


}