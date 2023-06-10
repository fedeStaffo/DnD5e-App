package com.progetto_dd.view.characters.crea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentRollBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class RollFragment : Fragment() {

    private var _binding: FragmentRollBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRollBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model del Personaggio
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Salva tutti i modificatori della razza
        val razza = viewModel.razzaPersonaggio.value
        binding.razzaNum.text = razza?.let { this.getModificatoreRazza(it, "Forza").toString() }
        binding.razzaNum2.text = razza?.let { this.getModificatoreRazza(it, "Destrezza").toString() }
        binding.razzaNum3.text = razza?.let { this.getModificatoreRazza(it, "Costituzione").toString() }
        binding.razzaNum4.text = razza?.let { this.getModificatoreRazza(it, "Intelligenza").toString() }
        binding.razzaNum5.text = razza?.let { this.getModificatoreRazza(it, "Saggezza").toString() }
        binding.razzaNum6.text = razza?.let { this.getModificatoreRazza(it, "Carisma").toString() }

        val rForza = binding.razzaNum.text.toString().toInt()
        val rDestrezza = binding.razzaNum2.text.toString().toInt()
        val rCostituzione = binding.razzaNum3.text.toString().toInt()
        val rIntelligenza = binding.razzaNum4.text.toString().toInt()
        val rSaggezza = binding.razzaNum5.text.toString().toInt()
        val rCarisma = binding.razzaNum6.text.toString().toInt()

        // Definisce il comportamento del bottone Calcola
        binding.btnCalcola.setOnClickListener {
            if(binding.numForza.text.toString() != "" &&
                binding.numDestrezza.text.toString() != "" &&
                binding.numCostituzione.text.toString() != "" &&
                binding.numIntelligenza.text.toString() != "" &&
                binding.numSaggezza.text.toString() != "" &&
                binding.numCarisma.text.toString() != "") {

                val forza = binding.numForza.text.toString().toInt()
                val destrezza = binding.numDestrezza.text.toString().toInt()
                val costituzione = binding.numCostituzione.text.toString().toInt()
                val intelligenza = binding.numIntelligenza.text.toString().toInt()
                val saggezza = binding.numSaggezza.text.toString().toInt()
                val carisma = binding.numCarisma.text.toString().toInt()

                if(this.getNumValidoDado(forza) && this.getNumValidoDado(destrezza) &&
                    this.getNumValidoDado(costituzione) && this.getNumValidoDado(intelligenza) &&
                    this.getNumValidoDado(saggezza) && this.getNumValidoDado(carisma))
                {
                    binding.totaleNum.text = (forza + rForza).toString()
                    binding.totaleNum2.text = (destrezza + rDestrezza).toString()
                    binding.totaleNum3.text = (costituzione + rCostituzione).toString()
                    binding.totaleNum4.text = (intelligenza + rIntelligenza).toString()
                    binding.totaleNum5.text = (saggezza + rSaggezza).toString()
                    binding.totaleNum6.text = (carisma + rCarisma).toString()
                }
                else {
                    Toast.makeText(activity, "Inserisci solo valori compresi tra 3 e 18", Toast.LENGTH_SHORT).show()
                }
            }
            else Toast.makeText(activity, "Inserisci tutti i lanci dei dadi", Toast.LENGTH_SHORT).show()
        }

        binding.btnAvanti.setOnClickListener {
            val tot1 = binding.totaleNum.text.toString().toInt()
            val tot2 = binding.totaleNum2.text.toString().toInt()
            val tot3 = binding.totaleNum3.text.toString().toInt()
            val tot4 = binding.totaleNum4.text.toString().toInt()
            val tot5 = binding.totaleNum5.text.toString().toInt()
            val tot6 = binding.totaleNum6.text.toString().toInt()

            if(this.getNumValidoTotale(tot1,tot2,tot3,tot4,tot5,tot6)){
                viewModel.setModForza(tot1)
                viewModel.setModDestrezza(tot2)
                viewModel.setModCostituzione(tot3)
                viewModel.setModIntelligenza(tot4)
                viewModel.setModSaggezza(tot5)
                viewModel.setModCarisma(tot6)
                findNavController().navigate(R.id.action_rollFragment_to_equipaggiamentoFragment)
            }
            else {
                Toast.makeText(activity, "Calcola prima i totali", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Metodo per calcolare il modificatore in base alla razza e caratteristica
    fun getModificatoreRazza(razza: String, caratteristica: String): Int {
        var num = 0
        if(razza == "Umano") num = 1
        if(razza == "Elfo" && caratteristica == "Destrezza") num = 2
        if(razza == "Nano" && caratteristica == "Costituzione") num = 2
        return num
    }

    // Verifica se un numero è valido per un lancio di dado (compreso tra 3 e 18)
    fun getNumValidoDado(num: Int): Boolean {
        return num in 3..18
    }

    // Verifica se tutti i numeri totali sono diversi da zero
    fun getNumValidoTotale(num1: Int, num2: Int, num3: Int, num4: Int, num5: Int, num6: Int): Boolean{
        return num1 != 0 && num2 != 0 && num3 != 0 && num4 != 0 && num5 != 0 && num6 != 0
    }
}
