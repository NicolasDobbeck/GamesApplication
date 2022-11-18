package br.senai.sp.jandira.gamesapplication.dao.gamesdao

import androidx.room.*
import br.senai.sp.jandira.gamesapplication.model.Games


@Dao
interface GamesDao {
    //Metodos que vamos usar, colocar, atualizar, apagar, pegar
    // todos os games e pegar games por id

    @Insert
    fun save (games: Games): Long

    @Delete
    fun delete(games: Games): Int

    @Update
    fun update(games: Games): Int

    @Query("SELECT * FROM tbl_games ORDER BY titulo ASC")
    fun getAll(): List<Games>

    @Query("SELECT * FROM tbl_games WHERE id = :id")
    fun getGamesById(id: Int): Games

}