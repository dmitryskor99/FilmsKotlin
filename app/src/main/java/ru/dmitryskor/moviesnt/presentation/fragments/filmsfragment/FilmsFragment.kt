package ru.dmitryskor.moviesnt.presentation.fragments.filmsfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collectLatest
import ru.dmitryskor.moviesnt.MainApp
import ru.dmitryskor.moviesnt.databinding.FragmentFilmsBinding
import ru.dmitryskor.moviesnt.presentation.adapters.AdapterRecyclerViewFilms

class FilmsFragment : Fragment() {

    private lateinit var binding: FragmentFilmsBinding
    private lateinit var viewModel: FilmsViewModel
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        AdapterRecyclerViewFilms(this.context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentMoviesRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.fragmentMoviesRecyclerView.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.films.collectLatest(adapter::submitData)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiFilmsRepositorySource =
            (requireActivity().application as MainApp).appComponent.getApi()

        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return FilmsViewModel(apiFilmsRepositorySource) as T
            }
        }).get(FilmsViewModel::class.java)
    }


    companion object {
        fun newInstance(): FilmsFragment {
            val fragment = FilmsFragment()
            return fragment
        }
    }
}