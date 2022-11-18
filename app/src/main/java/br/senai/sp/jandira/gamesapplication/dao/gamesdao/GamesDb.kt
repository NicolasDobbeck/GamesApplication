package br.senai.sp.jandira.gamesapplication.dao.gamesdao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.gamesapplication.model.Games

//Quando setamos essa classe como database precisamos declarar todas as entidades do seu banco
@Database(entities = [Games::class], version = 1)
abstract class GamesDb: RoomDatabase(){

    abstract fun gamesDao(): GamesDao

    //Os companion object são objetos singleton cujas propriedades e funções estão vinculadas a uma classe, mas não à instância dessa classe
    companion object{

        private lateinit var instance: GamesDb

        fun getDatabase(context: Context): GamesDb{
            if (!Companion::instance.isInitialized){
                instance = Room.databaseBuilder(context, GamesDb::class.java, "db_games").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}