package br.senai.sp.jandira.gamesapplication.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Quando puxamos esse atributo estamos dizendo que essa classe será uma tabela
@Entity(tableName = "tbl_console")
class Console {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    var nome_console = ""
    var fabricante = ""
    var descricao = ""
    var foto = ""

    @ColumnInfo(name = "ano_lancamento")
    var anoLancamento = 0
}