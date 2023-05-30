package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentMagieBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoDatabase
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoViewModel
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoViewModelFactory

class MagieFragment : Fragment() {

    private var _binding: FragmentMagieBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel
    private lateinit var viewModelInc: IncantesimoViewModel

    private lateinit var trucchettiAdapter: IncantesimoAdapter
    private lateinit var livello1Adapter: IncantesimoAdapter
    private lateinit var livello2Adapter: IncantesimoAdapter
    private lateinit var livello3Adapter: IncantesimoAdapter
    private lateinit var livello4Adapter: IncantesimoAdapter
    private lateinit var livello5Adapter: IncantesimoAdapter
    private lateinit var livello6Adapter: IncantesimoAdapter
    private lateinit var livello7Adapter: IncantesimoAdapter
    private lateinit var livello8Adapter: IncantesimoAdapter
    private lateinit var livello9Adapter: IncantesimoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMagieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trucchettiAdapter = IncantesimoAdapter(emptyList(),this)
        livello1Adapter = IncantesimoAdapter(emptyList(),this)
        livello2Adapter = IncantesimoAdapter(emptyList(),this)
        livello3Adapter = IncantesimoAdapter(emptyList(),this)
        livello4Adapter = IncantesimoAdapter(emptyList(),this)
        livello5Adapter = IncantesimoAdapter(emptyList(),this)
        livello6Adapter = IncantesimoAdapter(emptyList(),this)
        livello7Adapter = IncantesimoAdapter(emptyList(),this)
        livello8Adapter = IncantesimoAdapter(emptyList(),this)
        livello9Adapter = IncantesimoAdapter(emptyList(),this)

        binding.recyclerViewTrucchetti.adapter = trucchettiAdapter
        binding.recyclerViewLiv1.adapter = livello1Adapter
        binding.recyclerViewLiv2.adapter = livello2Adapter
        binding.recyclerViewLiv3.adapter = livello3Adapter
        binding.recyclerViewLiv4.adapter = livello4Adapter
        binding.recyclerViewLiv5.adapter = livello5Adapter
        binding.recyclerViewLiv6.adapter = livello6Adapter
        binding.recyclerViewLiv7.adapter = livello7Adapter
        binding.recyclerViewLiv8.adapter = livello8Adapter
        binding.recyclerViewLiv9.adapter = livello9Adapter

        binding.recyclerViewTrucchetti.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv1.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv2.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv3.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv4.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv5.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv6.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv7.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv8.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv9.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        val database = IncantesimoDatabase.getInstance(requireContext())
        val dao = database.incantesimoDao

        val viewModelFactory = IncantesimoViewModelFactory(dao)
        viewModelInc = ViewModelProvider(this, viewModelFactory).get(IncantesimoViewModel::class.java)

        val intent = requireActivity().intent

        val nomePersonaggio = intent.getStringExtra("nome")
        val utenteId = intent.getStringExtra("utente_id")

        if (nomePersonaggio != null && utenteId != null) {
            viewModel.getMagieFromFirestore(nomePersonaggio, utenteId).observe(viewLifecycleOwner) { magie ->

                val magieList = magie ?: emptyList()

                viewModelInc.getIncantesimiByNomi(magieList).observe(viewLifecycleOwner) { incantesimi ->

                    val trucchetti = incantesimi.filter { it.livello == 0 }
                    val livello1 = incantesimi.filter { it.livello == 1 }
                    val livello2 = incantesimi.filter { it.livello == 2 }
                    val livello3 = incantesimi.filter { it.livello == 3 }
                    val livello4 = incantesimi.filter { it.livello == 4 }
                    val livello5 = incantesimi.filter { it.livello == 5 }
                    val livello6 = incantesimi.filter { it.livello == 6 }
                    val livello7 = incantesimi.filter { it.livello == 7 }
                    val livello8 = incantesimi.filter { it.livello == 8 }
                    val livello9 = incantesimi.filter { it.livello == 9 }

                    // Aggiorna gli adapter per gli altri livelli con gli incantesimi filtrati
                    trucchettiAdapter.updateMagie(trucchetti)
                    livello1Adapter.updateMagie(livello1)
                    livello2Adapter.updateMagie(livello2)
                    livello3Adapter.updateMagie(livello3)
                    livello4Adapter.updateMagie(livello4)
                    livello5Adapter.updateMagie(livello5)
                    livello6Adapter.updateMagie(livello6)
                    livello7Adapter.updateMagie(livello7)
                    livello8Adapter.updateMagie(livello8)
                    livello9Adapter.updateMagie(livello9)
                }
            }
        }

        // Gestisce gli slot
        if (nomePersonaggio != null && utenteId != null) {

            val slotTotLiveData = viewModel.getSlotTotArray(nomePersonaggio, utenteId)
            val slotUsatiLiveData = viewModel.getSlotUsatiArray(nomePersonaggio, utenteId)

            slotTotLiveData.observe(viewLifecycleOwner) { slotTotArray ->
                val slotTotLivello1 = slotTotArray.getOrNull(0) ?: 0
                val slotTotLivello2 = slotTotArray.getOrNull(1) ?: 0
                val slotTotLivello3 = slotTotArray.getOrNull(2) ?: 0
                val slotTotLivello4 = slotTotArray.getOrNull(3) ?: 0
                val slotTotLivello5 = slotTotArray.getOrNull(4) ?: 0
                val slotTotLivello6 = slotTotArray.getOrNull(5) ?: 0
                val slotTotLivello7 = slotTotArray.getOrNull(6) ?: 0
                val slotTotLivello8 = slotTotArray.getOrNull(7) ?: 0
                val slotTotLivello9 = slotTotArray.getOrNull(8) ?: 0

                binding.slotTotali1.text = slotTotLivello1.toString()
                binding.slotTotali2.text = slotTotLivello2.toString()
                binding.slotTotali3.text = slotTotLivello3.toString()
                binding.slotTotali4.text = slotTotLivello4.toString()
                binding.slotTotali5.text = slotTotLivello5.toString()
                binding.slotTotali6.text = slotTotLivello6.toString()
                binding.slotTotali7.text = slotTotLivello7.toString()
                binding.slotTotali8.text = slotTotLivello8.toString()
                binding.slotTotali9.text = slotTotLivello9.toString()
            }

            slotUsatiLiveData.observe(viewLifecycleOwner) { slotUsatiArray ->
                val slotUsatiLivello1 = slotUsatiArray.getOrNull(0) ?: 0
                val slotUsatiLivello2 = slotUsatiArray.getOrNull(1) ?: 0
                val slotUsatiLivello3 = slotUsatiArray.getOrNull(2) ?: 0
                val slotUsatiLivello4 = slotUsatiArray.getOrNull(3) ?: 0
                val slotUsatiLivello5 = slotUsatiArray.getOrNull(4) ?: 0
                val slotUsatiLivello6 = slotUsatiArray.getOrNull(5) ?: 0
                val slotUsatiLivello7 = slotUsatiArray.getOrNull(6) ?: 0
                val slotUsatiLivello8 = slotUsatiArray.getOrNull(7) ?: 0
                val slotUsatiLivello9 = slotUsatiArray.getOrNull(8) ?: 0

                binding.slotUsati1.text = slotUsatiLivello1.toString()
                binding.slotUsati2.text = slotUsatiLivello2.toString()
                binding.slotUsati3.text = slotUsatiLivello3.toString()
                binding.slotUsati4.text = slotUsatiLivello4.toString()
                binding.slotUsati5.text = slotUsatiLivello5.toString()
                binding.slotUsati6.text = slotUsatiLivello6.toString()
                binding.slotUsati7.text = slotUsatiLivello7.toString()
                binding.slotUsati8.text = slotUsatiLivello8.toString()
                binding.slotUsati9.text = slotUsatiLivello9.toString()
            }
        }

        // Bottoni Modifica slot
        binding.bottoneModifica1.setOnClickListener {
            this.showSlotEditDialog(1)
        }
        binding.bottoneModifica2.setOnClickListener {
            this.showSlotEditDialog(2)
        }
        binding.bottoneModifica3.setOnClickListener {
            this.showSlotEditDialog(3)
        }
        binding.bottoneModifica4.setOnClickListener {
            this.showSlotEditDialog(4)
        }
        binding.bottoneModifica5.setOnClickListener {
            this.showSlotEditDialog(5)
        }
        binding.bottoneModifica6.setOnClickListener {
            this.showSlotEditDialog(6)
        }
        binding.bottoneModifica7.setOnClickListener {
            this.showSlotEditDialog(7)
        }
        binding.bottoneModifica8.setOnClickListener {
            this.showSlotEditDialog(8)
        }
        binding.bottoneModifica9.setOnClickListener {
            this.showSlotEditDialog(9)
        }

        // Bottone lista incantesimi
        binding.btnAggiungiIncantesimo.setOnClickListener {
            findNavController().navigate(R.id.action_magieFragment_to_listaMagieFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showSlotEditDialog(livello: Int) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Modifica slot - Livello $livello")

        val view = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_edit_slot, null)
        builder.setView(view)

        val slotTotEditText: EditText = view.findViewById(R.id.editTextSlotTot)
        val slotUsatiEditText: EditText = view.findViewById(R.id.editTextSlotUsati)

        val intent = requireActivity().intent
        val nomePersonaggio = intent.getStringExtra("nome")
        val utenteId = intent.getStringExtra("utente_id")

        // Recupera i valori attuali degli slot totali e usati per il livello specificato
        if (nomePersonaggio != null && utenteId != null) {
            val slotTotArray = viewModel.getSlotTotArray(nomePersonaggio, utenteId)
            val slotUsatiArray = viewModel.getSlotUsatiArray(nomePersonaggio, utenteId)

            slotTotArray.observe(viewLifecycleOwner) { slotTotList ->
                val slotTot = slotTotList.getOrNull(livello - 1) ?: 0
                slotTotEditText.setText(slotTot.toString())
            }

            slotUsatiArray.observe(viewLifecycleOwner) { slotUsatiList ->
                val slotUsati = slotUsatiList.getOrNull(livello - 1) ?: 0
                slotUsatiEditText.setText(slotUsati.toString())
            }

            builder.setPositiveButton("Salva") { dialog, _ ->
                val newSlotTot = slotTotEditText.text.toString().toIntOrNull() ?: 0
                val newSlotUsati = slotUsatiEditText.text.toString().toIntOrNull() ?: 0

                // Esegui l'aggiornamento degli slot totali e usati nel ViewModel o nella logica appropriata
                viewModel.updateSlotTotUsati(requireContext(), nomePersonaggio, utenteId, livello, newSlotTot, newSlotUsati)

                dialog.dismiss()
            }

            builder.setNegativeButton("Annulla") { dialog, _ ->
                dialog.dismiss()
            }

            val dialog = builder.create()
            dialog.show()
        }
    }


}
