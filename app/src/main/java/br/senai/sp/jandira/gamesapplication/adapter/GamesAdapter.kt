package br.senai.sp.jandira.gamesapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.model.Games


class GamesAdapter(var gamesList: List<Games>, var context: Context): RecyclerView.Adapter<GamesAdapter.GamesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesAdapter.GamesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)

        return GamesHolder(view)
    }

    override fun onBindViewHolder(holder: GamesAdapter.GamesHolder, position: Int) {
        val games = gamesList[position]

        holder.textViewCompany.text = games.estudio
        holder.textTitle.text = games.titulo
        holder.textDiscription.text = games.descricao
//        holder.imageGame.setImageBitmap(games.foto)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    class GamesHolder(view: View):RecyclerView.ViewHolder(view) {
        val textViewCompany: TextView = view.findViewById(R.id.text_view_company)
        val textTitle: TextView = view.findViewById(R.id.text_view_title)
        val textDiscription: TextView = view.findViewById(R.id.text_view_description)
        val imageGame: ImageView = view.findViewById(R.id.image_view_game)
    }
}