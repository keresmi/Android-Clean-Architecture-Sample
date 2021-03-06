package pl.akademiaandroida.android_clean_architecture_sample.features.episodes.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.akademiaandroida.android_clean_architecture_sample.R
import pl.akademiaandroida.android_clean_architecture_sample.core.extensions.inflate
import pl.akademiaandroida.android_clean_architecture_sample.databinding.ItemEpisodeBinding

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private val episodes = mutableListOf<EpisodeDisplayable>()

    fun setItems(episodes: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) this.episodes.clear()

        this.episodes.addAll(episodes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            parent.inflate(R.layout.item_episode)
        )
    }

    override fun getItemCount() = episodes.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemEpisodeBinding.bind(itemView)

        fun bind(episode: EpisodeDisplayable) {
            with(binding) {
                name.text = episode.fullName
                airDate.text = episode.airDate
            }
        }

    }
}