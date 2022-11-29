package com.pablogonzalezpatarro.superheroapi.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pablogonzalezpatarro.superheroapi.Hero
import com.pablogonzalezpatarro.superheroapi.R
import com.pablogonzalezpatarro.superheroapi.databinding.FragmentMainBinding
import com.pablogonzalezpatarro.superheroapi.ui.detail.DetailFragment

class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewModel: MainViewModel by viewModels{ MainViewModelFactory()}
    private lateinit var binding: FragmentMainBinding
    private val adapter = HeroAdapter(){ hero -> viewModel.navigateTo(hero)}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding =  FragmentMainBinding.bind(view).apply {
            recycler.adapter = adapter
        }
        //Ponemos el nombre de la aplicación en la actionBar.
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)

        //
        viewModel.state.observe(viewLifecycleOwner){state->
            //Mientras la lista de héroes no sea nula...
            state.heroes?.let {
                //... se la mandamos al adapter.
                adapter.heroes = state.heroes
                adapter.notifyDataSetChanged()
            }

            //Definimos la navegación.
            state.navigateTo?.let {
                findNavController().navigate(
                    R.id.action_mainFragment_to_detailFragment,
                    bundleOf(DetailFragment.EXTRA_HERO to it)
                )
                //cambiamos el estado de la navegación a null.
                viewModel.onNavigateDone()
            }

        }


    }//Fin de onViewCreated.



}//Fin del mainFragment.

//Lista de prueba.
/*
private val heroes = (1..100).map {
    Hero(id = null,
        nombre = "Heroe $it",
        imagen = "https://loremflickr.com/240/320/paris?lock=$it",
        genero = null,
        estadísticas = null
    )

*/

