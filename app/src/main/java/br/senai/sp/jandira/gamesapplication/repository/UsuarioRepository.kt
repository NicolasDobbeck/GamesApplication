package br.senai.sp.jandira.gamesapplication.repository

import android.content.Context
import android.provider.ContactsContract
import br.senai.sp.jandira.gamesapplication.dao.usuariodao.UsuarioDb
import br.senai.sp.jandira.gamesapplication.model.Usuario

class UsuarioRepository(context: Context) {
    private val db = UsuarioDb.getDatabase(context).usuarioDao()

    fun save (usuario: Usuario): Long {
        return db.save(usuario)
    }

    fun delete (usuario: Usuario): Int{
        return  db.delete(usuario)
    }

    fun update (usuario: Usuario): Int{
        return  db.update(usuario)
    }

    fun getAll (): List<Usuario>{
        return db.getAll()
    }

    fun getContactById (id: Int): Usuario{
        return db.getUsuarioById(id)
    }

    fun getUsuarioByEmail(email: String): Usuario{
        return db.getUsuarioByEmail(email)
    }
}