package com.mokhtarradreza.movie.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.mokhtarradreza.movie.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {

    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    private val viewModel: SearchViewModel by viewModels()

    private lateinit var adapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button = view.findViewById(R.id.fragment_movie_search_button);
        editText = view.findViewById(R.id.fragment_movie_search_editText);
        progressBar = view.findViewById(R.id.fragment_movie_search_progressBar);
        recyclerView = view.findViewById(R.id.fragment_movie_search_recyclerView);

        adapter = SearchAdapter(requireContext())
        recyclerView.adapter = adapter

        button.setOnClickListener {
            viewModel.searchMovie(editText.text.toString())
        }

        viewModel.state.observe(viewLifecycleOwner, ::updateState)
    }

    private fun updateState(state: SearchState) {
        when(state) {
            is SearchState.ErrorState -> {
                progressBar.isVisible = false
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                adapter.setData(null)
            }
            is SearchState.LoadingState -> {
                progressBar.isVisible = true
            }
            is SearchState.SuccessState -> {
                progressBar.isVisible = false

                adapter.setData(state.movies)
            }
        }
    }
}