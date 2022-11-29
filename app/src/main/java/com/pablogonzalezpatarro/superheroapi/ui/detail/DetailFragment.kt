package com.pablogonzalezpatarro.superheroapi.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.pablogonzalezpatarro.superheroapi.Hero
import com.pablogonzalezpatarro.superheroapi.R
import com.pablogonzalezpatarro.superheroapi.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val viewModel: DetailViewModel by viewModels {
        DetailViewModelFactory(arguments?.getParcelable<Hero>(EXTRA_HERO)!!)
    }

    //Parte estática de la clase.
    companion object{
        const val EXTRA_HERO = "DetailActivity:hero"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)

        viewModel.hero.observe(viewLifecycleOwner){ hero->
            //Asignamos a cada uno de los campos del detail su correspondiente
            // valor de la variable hero.
            binding.tvDetailNombre.text = hero.nombre
            binding.tvDetailGenero.text = hero.genero
            binding.tvDetailStat.text = "aaa"
            Glide.with(binding.imagen)
                .load(hero.imagen)
                .into(binding.imagen)
        }
    }





}