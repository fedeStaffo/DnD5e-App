package com.progetto_dd.view.characters.crea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentClassBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.utils.ButtonUtils


class ClassFragment : Fragment() {

    private var _binding: FragmentClassBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    private var bardoSelected = false
    private var ladroSelected = false
    private var guerrieroSelected = false
    private var magoSelected = false
    private var barbaroSelected = false
    private var chiericoSelected = false
    private var druidoSelected = false
    private var monacoSelected = false
    private var paladinoSelected = false
    private var rangerSelected = false
    private var stregoneSelected = false
    private var warlockSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        _binding = FragmentClassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)



        // Listener che definiscono il comportamento dei bottoni di selezione chiamando il
        // metodo updateButtonState della classe ButtonUtils
        val buttonUtils = ButtonUtils(requireContext())

        binding.scegliBarbaro.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago,
                binding.scegliChierico, binding.scegliDruido, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliStregone, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliBarbaro, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = true
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliBardo.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliDruido, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliStregone, binding.scegliWarlock)
            buttonUtils.updateButtonState(binding.scegliBardo, unclickedButtons)
            bardoSelected = true
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliChierico.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliDruido, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliStregone, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliChierico, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = true
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliDruido.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliStregone, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliDruido, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = false
            druidoSelected = true
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliLadro.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliDruido, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliStregone, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliLadro, unclickedButtons)
            bardoSelected = false
            ladroSelected = true
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliGuerriero.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliLadro, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliDruido, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliStregone, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliGuerriero, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = true
            magoSelected = false
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliMago.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliDruido, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliStregone, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliMago, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = true
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliMonaco.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliDruido, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliStregone, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliMonaco, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = true
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliPaladino.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliDruido, binding.scegliMonaco,
                binding.scegliRanger, binding.scegliStregone, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliPaladino, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = true
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliRanger.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliDruido, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliStregone, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliRanger, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = true
            stregoneSelected = false
            warlockSelected = false
        }

        binding.scegliStregone.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliDruido, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliWarlock, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliStregone, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = true
            warlockSelected = false
        }

        binding.scegliWarlock.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago, binding.scegliBarbaro,
                binding.scegliChierico, binding.scegliDruido, binding.scegliMonaco, binding.scegliPaladino,
                binding.scegliRanger, binding.scegliStregone, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliWarlock, unclickedButtons)
            bardoSelected = false
            ladroSelected = false
            guerrieroSelected = false
            magoSelected = false
            barbaroSelected = false
            druidoSelected = false
            chiericoSelected = false
            monacoSelected = false
            paladinoSelected = false
            rangerSelected = false
            stregoneSelected = false
            warlockSelected = true
        }


        // Listener che definiscono il comportamento dei bottoni di info
        binding.infoBarbaro.setOnClickListener {
            viewModel.setClassePersonaggio("Barbaro")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoBardo.setOnClickListener {
            viewModel.setClassePersonaggio("Bardo")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoChierico.setOnClickListener {
            viewModel.setClassePersonaggio("Chierico")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoDruido.setOnClickListener {
            viewModel.setClassePersonaggio("Druido")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoGuerriero.setOnClickListener {
            viewModel.setClassePersonaggio("Guerriero")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoLadro.setOnClickListener {
            viewModel.setClassePersonaggio("Ladro")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoMago.setOnClickListener {
            viewModel.setClassePersonaggio("Mago")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoMonaco.setOnClickListener {
            viewModel.setClassePersonaggio("Monaco")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoPaladino.setOnClickListener {
            viewModel.setClassePersonaggio("Paladino")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoRanger.setOnClickListener {
            viewModel.setClassePersonaggio("Ranger")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoStregone.setOnClickListener {
            viewModel.setClassePersonaggio("Stregone")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoWarlock.setOnClickListener {
            viewModel.setClassePersonaggio("Warlock")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        // Definisce il comportamento del tasto avanti
        binding.btnAvanti.setOnClickListener {
            val classeSelezionata = when {
                barbaroSelected -> "Barbaro"
                bardoSelected -> "Bardo"
                chiericoSelected -> "Chierico"
                druidoSelected -> "Druido"
                ladroSelected -> "Ladro"
                guerrieroSelected -> "Guerriero"
                magoSelected -> "Mago"
                monacoSelected -> "Monaco"
                paladinoSelected -> "Paladino"
                rangerSelected -> "Ranger"
                stregoneSelected -> "Stregone"
                warlockSelected -> "Warlock"
                else -> null
            }

            if (classeSelezionata == null) {
                Toast.makeText(requireContext(), "Selezionare una classe!", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.setClassePersonaggio(classeSelezionata)
                findNavController().navigate(R.id.action_classFragment_to_competenzeFragment)
            }
        }
    }

    // Resetta i booleani se si torna indietro
    override fun onResume() {
        super.onResume()
        bardoSelected = false
        ladroSelected = false
        guerrieroSelected = false
        magoSelected = false
        barbaroSelected = false
        druidoSelected = false
        chiericoSelected = false
        monacoSelected = false
        paladinoSelected = false
        rangerSelected = false
        stregoneSelected = false
        warlockSelected = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}