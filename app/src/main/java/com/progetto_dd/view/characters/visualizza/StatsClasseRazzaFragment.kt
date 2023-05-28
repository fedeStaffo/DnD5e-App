package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentStatsClasseRazzaBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class StatsClasseRazzaFragment : Fragment() {

    private var _binding: FragmentStatsClasseRazzaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentStatsClasseRazzaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        val textViewRazzaNascosta = binding.Razzanascosta
        val textViewClasseNascosta = binding.Classenascosta
        val textViewSottoClasseNascosta = binding.Sottoclassenascosta
        val spinner = binding.spinner

        val intent = requireActivity().intent

        val razza = intent.getStringExtra("razza")
        val classe = intent.getStringExtra("classe")

        val classArray = when (classe) {
            "Bardo" -> resources.getStringArray(R.array.sottoclassi_bardo)
            "Guerriero" -> resources.getStringArray(R.array.sottoclassi_guerriero)
            "Ladro" ->resources.getStringArray(R.array.sottoclassi_ladro)
            "Mago" ->resources.getStringArray(R.array.sottoclassi_mago)
            else -> arrayOf()
        }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, classArray)
        binding.spinner.adapter = adapter

        binding.bottoneInfoRazza.setOnClickListener{
            if(textViewRazzaNascosta.visibility == View.VISIBLE){
                textViewRazzaNascosta.text = ""
                textViewRazzaNascosta.visibility = View.GONE
            } else{
                when(razza){
                    "Elfo" -> {
                        textViewRazzaNascosta.text = getString(R.string.Elfo_info)
                    }
                    "Umano" -> {
                        textViewRazzaNascosta.text =getString(R.string.Umano_info)
                    }
                    "Nano" -> {
                        textViewRazzaNascosta.text = getString(R.string.Nano_info)
                    }
                }
                textViewRazzaNascosta.visibility = View.VISIBLE
            }

        }

        binding.bottoneInfoClasse.setOnClickListener {
            if(textViewClasseNascosta.visibility == View.VISIBLE){
                textViewClasseNascosta.text = ""
                textViewClasseNascosta.visibility = View.GONE
            } else{
                when(classe){
                    "Bardo" -> {
                        textViewClasseNascosta.text =  getString(R.string.Bardo_info)
                    }
                    "Guerriero" -> {

                        textViewClasseNascosta.text = getString(R.string.Guerriero_info)
                    }
                    "Ladro" -> {
                        textViewClasseNascosta.text =  getString(R.string.Ladro_info)
                    }
                    "Mago" -> {
                        textViewClasseNascosta.text = getString(R.string.Mago_info)
                    }
                }
                textViewClasseNascosta.visibility = View.VISIBLE
            }
        }

        binding.bottoneInfoSottoClasse.setOnClickListener{
            if(textViewSottoClasseNascosta.visibility == View.VISIBLE){
                textViewSottoClasseNascosta.text = ""
                textViewSottoClasseNascosta.visibility = View.GONE
            } else{
                when(spinner.selectedItem as String){
                    "Collegio della sapienza" -> textViewSottoClasseNascosta.text = getString(R.string.collegio_sapienza)
                    "Collegio del valore" -> textViewSottoClasseNascosta.text = getString(R.string.collegio_valore)
                    "Campione" -> textViewSottoClasseNascosta.text = getString(R.string.campione)
                    "Maestro di battaglia" -> textViewSottoClasseNascosta.text = getString(R.string.maestro_di_battaglia)
                    "Cavaliere mistico" -> textViewSottoClasseNascosta.text = getString(R.string.cavaliere_mistico)
                    "Furfante" -> textViewSottoClasseNascosta.text = getString(R.string.furfante)
                    "Assassino" -> textViewSottoClasseNascosta.text = getString(R.string.assassino)
                    "Mistificatore arcano" -> textViewSottoClasseNascosta.text = getString(R.string.mistificatore_arcano)
                    "Scuola di abiurazione" -> textViewSottoClasseNascosta.text = getString(R.string.abiurazione_info)
                    "Scuola di ammaliamento" -> textViewSottoClasseNascosta.text = getString(R.string.ammaliamento_info)
                    "Scuola di divinazione" -> textViewSottoClasseNascosta.text = getString(R.string.divinazione_info)
                    "Scuola di illusione" -> textViewSottoClasseNascosta.text = getString(R.string.illusione_info)
                    "Scuola di invocazione" -> textViewSottoClasseNascosta.text = getString(R.string.invocazione_info)
                    "Scuola di evocazione" -> textViewSottoClasseNascosta.text = getString(R.string.evocazione_info)
                    "Scuola di necromanzia" -> textViewSottoClasseNascosta.text = getString(R.string.necromanzia_info)
                    "Scuola di trasmutazione" -> textViewSottoClasseNascosta.text = getString(R.string.trasmutazione_info)
                }
                textViewSottoClasseNascosta.visibility = View.VISIBLE
            }
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}