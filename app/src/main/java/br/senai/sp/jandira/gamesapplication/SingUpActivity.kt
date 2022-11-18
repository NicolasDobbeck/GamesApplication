package br.senai.sp.jandira.gamesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.databinding.ActivityMainBinding
import br.senai.sp.jandira.gamesapplication.databinding.ActivitySingUpBinding

class SingUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_save){
            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
            return true
        }else if (item.itemId == R.id.menu_settings){
            Toast.makeText(this, "Configurations", Toast.LENGTH_SHORT).show()
            return true
        }else if (item.itemId == R.id.menu_sair){
            Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show()
            return true
        }

        return false
    }




    //Chama o menu criado
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        //infla o menu que ele me passou no meu layout
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

}