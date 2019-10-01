package com.example.themoviedb_mvpstructure.popular_people_package

import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.themoviedb_mvpstructure.R
import com.example.themoviedb_mvpstructure.Utilities.Companion.PROFILE_IMAGE_URL
import com.example.themoviedb_mvpstructure.model.Image
import com.example.themoviedb_mvpstructure.model.PopularPeople
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_popular_people.view.*

class PopularPeopleAdapter(val getImage: (url: String, id: Int) -> Unit,
                           val onCellClick: (actor: PopularPeople) -> Unit) :
    RecyclerView.Adapter<PopularPeopleAdapter.ActorViewHolder>() {

    private val list = arrayListOf<PopularPeople>()

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_popular_people, null)
        return ActorViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun add(list: List<PopularPeople>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun updateImage(id: Int, image: Image) {
        list.firstOrNull {
            it.id == id
        }?.image = image
        notifyDataSetChanged()
    }

    inner class ActorViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(actor: PopularPeople) {
            with(view) {
                person_name.text = actor.name
                known_for_department.text = actor.popularity.toString()

                Picasso.with(context).load(PROFILE_IMAGE_URL + actor.profilePath)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(person_image)

                view.setOnClickListener {
                    onCellClick(actor)
                }
            }
        }
    }
}