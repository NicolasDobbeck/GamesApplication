package br.senai.sp.jandira.gamesapplication.dao.usuariodao

import androidx.room.*
import br.senai.sp.jandira.gamesapplication.model.Usuario

@Dao
interface UsuarioDao {
    //Metodos que vamos usar, colocar, atualizar, apagar, pegar
    // todos os usuarios e pegar usuario por id

    @Insert
    fun save (usuario: Usuario): Long

    @Delete
    fun delete(usuario: Usuario): Int

    @Update
    fun update(usuario: Usuario): Int

    @Query("SELECT * FROM tbl_usuario ORDER BY nome ASC")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM tbl_usuario WHERE id = :id")
    fun getUsuarioById(id: Int): List<Usuario>
}