package br.senai.sp.jandira.gamesapplication.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_games")
class Games {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    var foto= ""
    var titulo = ""
    var descricao = ""
    var estudio = ""

    @ColumnInfo(name = "ano_lancamento")
    var anoLancamento = 0

    var finalizado = 0
}