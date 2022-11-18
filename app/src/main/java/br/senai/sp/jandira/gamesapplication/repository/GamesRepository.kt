package br.senai.sp.jandira.gamesapplication.repository

import android.content.Context
import br.senai.sp.jandira.gamesapplication.dao.gamesdao.GamesDb
import br.senai.sp.jandira.gamesapplication.model.Games

class GamesRepository(context: Context) {

    private val db = GamesDb.getDatabase(context).gamesDao()

    fun save (games: Games): Long {
        return db.save(games)
    }

    fun delete (games: Games): Int {
        return db.delete(games)
    }

    fun update (games: Games): Int {
        return  db.update(games)
    }

    fun getAll (): List<Games>{
        return db.getAll()
    }

    fun getGamesById (id: Int): Games{
        return db.getGamesById(id)
    }
}