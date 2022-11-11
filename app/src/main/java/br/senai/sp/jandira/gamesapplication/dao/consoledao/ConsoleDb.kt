package br.senai.sp.jandira.gamesapplication.dao.consoledao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.gamesapplication.model.Console


//Quando setamos essa classe como database precisamos declarar todas as
@Database(entities = [Console::class], version = 1)
abstract class ConsoleDb: RoomDatabase() {

    abstract fun consoleDao(): ConsoleDao

    //Os companion object são objetos singleton cujas propriedades e funções estão vinculadas a uma classe, mas não à instância dessa classe
    companion object {

        private lateinit var instance: ConsoleDb

        fun getDataBase(context: Context): ConsoleDb {
            if(!Companion::instance.isInitialized){
                instance = Room.databaseBuilder(context, ConsoleDb::class.java, "db_games_application").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}