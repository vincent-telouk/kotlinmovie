package com.mokhtarradreza.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.mokhtarradreza.movie.presentation.detail.DetailFragment
import com.mokhtarradreza.movie.presentation.search.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.commit {
            replace(R.id.fragment_container, SearchFragment())
        }

        findViewById<FragmentContainerView>(R.id.fragment_container2)?.let {
            supportFragmentManager.commit {
                add(R.id.fragment_container2, DetailFragment())
            }
        }
    }
}