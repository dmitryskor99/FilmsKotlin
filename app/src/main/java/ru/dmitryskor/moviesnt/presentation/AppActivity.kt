package ru.dmitryskor.moviesnt.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.dmitryskor.moviesnt.databinding.ActivityAppBinding
import ru.dmitryskor.moviesnt.presentation.fragments.filmsfragment.FilmsFragment

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = FilmsFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(binding.containerFragment.id, fragment)
                .commit()
        }
    }

    override fun onBackPressed() {}
}