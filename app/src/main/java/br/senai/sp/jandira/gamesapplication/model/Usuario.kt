package br.senai.sp.jandira.gamesapplication.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_usuario")
class Usuario {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    var foto = ""
    var email = ""
    var senha = ""
    var nome = ""
    var cidade = ""

    @ColumnInfo(name = "data_nascimento")
    var dataNascimento = ""

    var nivel = NiveisEnum.INICIANTE
    var console = 0
    var sexo:Char? = null

}