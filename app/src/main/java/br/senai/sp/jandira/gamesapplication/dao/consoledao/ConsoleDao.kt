package br.senai.sp.jandira.gamesapplication.dao.consoledao

import androidx.room.*
import br.senai.sp.jandira.gamesapplication.model.Console

@Dao
interface ConsoleDao {
    //Metodos que vamos usar, colocar, atualizar, apagar, pegar
    // todos os contatos e pegar contato por id

    @Insert
    fun save(console: Console): Long

    @Delete
    fun delete(console: Console): Int

    @Update
    fun update(console: Console): Int

    @Query("SELECT * FROM tbl_console ORDER BY nome ASC")
    fun getAll(): List<Console>

    @Query("SELECT * FROM tbl_console WHERE id = :id")
    fun getConsoleById(id: Int): List<Console>
}