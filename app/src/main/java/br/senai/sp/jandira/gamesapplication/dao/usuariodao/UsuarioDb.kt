package br.senai.sp.jandira.gamesapplication.dao.usuariodao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.gamesapplication.model.Usuario

//Quando setamos essa classe como database precisamos declarar todas as entidades do seu banco
@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDb: RoomDatabase(){

    abstract fun usuarioDao(): UsuarioDao

    //Os companion object são objetos singleton cujas propriedades e funções estão vinculadas a uma classe, mas não à instância dessa classe
    companion object{

        private lateinit var instance: UsuarioDb

        fun getDatabase(context: Context): UsuarioDb{
            if (!Companion::instance.isInitialized){
                instance = Room.databaseBuilder(context, UsuarioDb::class.java, "db_usuario").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}