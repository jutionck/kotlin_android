package com.example.first_android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.first_android.R
import com.example.first_android.room.music.Album
import com.example.first_android.room.music.Song
import com.example.first_android.view_model.AlbumViewModel
import kotlinx.android.synthetic.main.fragment_add_album.*
import kotlinx.android.synthetic.main.fragment_add_album.button_save
import kotlinx.android.synthetic.main.fragment_add_album.input_song_title
import kotlinx.android.synthetic.main.fragment_add_song.*

class FragmentAddSong : Fragment(), View.OnClickListener {

    private val songViewModel by activityViewModels<AlbumViewModel>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController= Navigation.findNavController(view)
        button_save.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            button_save->{
                val albumId = arguments?.getInt("albumId") ?: 1
                val songTitle = input_song_title.text.toString()
                val songDuration = input_song_duration.text.toString()
                songViewModel.createNewSong(Song(songName = songTitle, songDuration = songDuration, songAlbumId = albumId ))
                Toast.makeText(v?.context,"SUCCESS: Add Album", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_fragmentAddSong_pop)
            }

        }
    }
}