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
        // Infla il layout per questo fragment utilizzando ViewBinding
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
            "Ladro" -> resources.getStringArray(R.array.sottoclassi_ladro)
            "Mago" -> resources.getStringArray(R.array.sottoclassi_mago)
            "Barbaro" -> resources.getStringArray(R.array.sottoclassi_barbaro)
            "Chierico" -> resources.getStringArray(R.array.sottoclassi_chierico)
            "Druido" -> resources.getStringArray(R.array.sottoclassi_druido)
            "Monaco" -> resources.getStringArray(R.array.sottoclassi_monaco)
            "Paladino" -> resources.getStringArray(R.array.sottoclassi_paladino)
            "Ranger" -> resources.getStringArray(R.array.sottoclassi_ranger)
            "Stregone" -> resources.getStringArray(R.array.sottoclassi_stregone)
            "Warlock" -> resources.getStringArray(R.array.sottoclassi_warlock)
            else -> arrayOf()
        }
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, classArray)
        binding.spinner.adapter = adapter

        // Gestione del click sul bottone "Info Razza"
        binding.bottoneInfoRazza.setOnClickListener{
            if(textViewRazzaNascosta.visibility == View.VISIBLE){
                textViewRazzaNascosta.text = ""
                textViewRazzaNascosta.visibility = View.GONE
            } else{
                when(razza){
                    "Elfo alto" -> textViewRazzaNascosta.text = getString(R.string.elfo_alto_totale)
                    "Elfo dei boschi" -> textViewRazzaNascosta.text = getString(R.string.elfo_dei_boschi_totale)
                    "Elfo oscuro" -> textViewRazzaNascosta.text = getString(R.string.elfo_oscuro_totale)

                    "Umano" -> textViewRazzaNascosta.text =getString(R.string.umano_info)

                    "Nano delle colline" -> textViewRazzaNascosta.text = getString(R.string.nano_delle_colline_totale)
                    "Nano delle montagne" -> textViewRazzaNascosta.text = getString(R.string.nano_delle_montagne_totale)

                    "Dragonide d'argento", "Dragonide bianco", "Dragonide blu", "Dragonide di bronzo", "Dragonide nero", "Dragonide d'oro", "Dragonide d'ottone", "Dragonide di rame", "Dragonide rosso", "Dragonide verde" -> {
                        textViewRazzaNascosta.text = getString(R.string.dragonide_info)
                    }

                    "Gnomo delle foreste" -> textViewRazzaNascosta.text = getString(R.string.gnomo_delle_foreste_totale)
                    "Gnomo delle rocce" -> textViewRazzaNascosta.text = getString(R.string.gnomo_delle_rocce_totale)

                    "Halfling piedelesto" -> textViewRazzaNascosta.text = getString(R.string.halfling_piedelesto_totale)
                    "Halfling tozzo" -> textViewRazzaNascosta.text = getString(R.string.halfling_tozzo_totale)

                    "Tiefling" -> textViewRazzaNascosta.text = getString(R.string.tiefling_info)

                    "Mezzorco" -> textViewRazzaNascosta.text = getString(R.string.mezzorco_info)

                    "Mezzelfo" -> textViewRazzaNascosta.text = getString(R.string.mezzelfo_info)
                }
                textViewRazzaNascosta.visibility = View.VISIBLE
            }

        }

        // Gestione del click sul bottone "Info Classe"
        binding.bottoneInfoClasse.setOnClickListener {
            if(textViewClasseNascosta.visibility == View.VISIBLE){
                textViewClasseNascosta.text = ""
                textViewClasseNascosta.visibility = View.GONE
            } else{
                when(classe){
                    "Bardo" -> textViewClasseNascosta.text =  getString(R.string.bardo_info)
                    "Guerriero" -> textViewClasseNascosta.text = getString(R.string.guerriero_info)
                    "Ladro" -> textViewClasseNascosta.text =  getString(R.string.ladro_info)
                    "Mago" -> textViewClasseNascosta.text = getString(R.string.mago_info)
                    "Barbaro" -> textViewClasseNascosta.text = getString(R.string.barbaro_info)
                    "Chierico" -> textViewClasseNascosta.text = getString(R.string.chierico_info)
                    "Druido" -> textViewClasseNascosta.text = getString(R.string.druido_info)
                    "Monaco" -> textViewClasseNascosta.text = getString(R.string.monaco_info)
                    "Paladino" -> textViewClasseNascosta.text = getString(R.string.paladino_info)
                    "Ranger" -> textViewClasseNascosta.text = getString(R.string.ranger_info)
                    "Stregone" -> textViewClasseNascosta.text = getString(R.string.stregone_info)
                    "Warlock" -> textViewClasseNascosta.text = getString(R.string.warlock_info)
                }
                textViewClasseNascosta.visibility = View.VISIBLE
            }
        }

        // Gestione del click sul bottone "Info SottoClasse"
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
                    "Cammino del berserker" -> textViewSottoClasseNascosta.text = getString(R.string.cammino_del_berserker_info)
                    "Cammino del combattente totemico" -> textViewSottoClasseNascosta.text = getString(R.string.cammino_del_combattente_totemico_info)
                    "Dominio della conoscenza" -> textViewSottoClasseNascosta.text = getString(R.string.dominio_della_conoscenza_info)
                    "Dominio dell\'inganno" -> textViewSottoClasseNascosta.text = getString(R.string.dominio_dell_inganno_info)
                    "Dominio della guerra" -> textViewSottoClasseNascosta.text = getString(R.string.dominio_della_guerra_info)
                    "Dominio della luce" -> textViewSottoClasseNascosta.text = getString(R.string.dominio_della_luce_info)
                    "Dominio della natura" -> textViewSottoClasseNascosta.text = getString(R.string.dominio_della_natura_info)
                    "Dominio della tempesta" -> textViewSottoClasseNascosta.text = getString(R.string.dominio_della_tempesta_info)
                    "Dominio della vita" -> textViewSottoClasseNascosta.text = getString(R.string.dominio_della_vita_info)
                    "Circolo della luna" -> textViewSottoClasseNascosta.text = getString(R.string.circolo_della_luna_info)
                    "Circolo della terra" -> textViewSottoClasseNascosta.text = getString(R.string.circolo_della_terra_info)
                    "Via dei 4 elementi" -> textViewSottoClasseNascosta.text = getString(R.string.via_dei_quattro_elementi_info)
                    "Via dell\'ombra" -> textViewSottoClasseNascosta.text = getString(R.string.via_dell_ombra_info)
                    "Via della mano aperta" -> textViewSottoClasseNascosta.text = getString(R.string.via_della_mano_aperta_info)
                    "Giuramento degli antichi" -> textViewSottoClasseNascosta.text = getString(R.string.giuramento_degli_antichi_info)
                    "Giuramento della vendetta" -> textViewSottoClasseNascosta.text = getString(R.string.giuramento_della_vendetta_info)
                    "Giuramento di devozione" -> textViewSottoClasseNascosta.text = getString(R.string.giuramento_di_devozione_info)
                    "Cacciatore" -> textViewSottoClasseNascosta.text = getString(R.string.cacciatore_info)
                    "Signore delle bestie" -> textViewSottoClasseNascosta.text = getString(R.string.signore_delle_bestie_info)
                    "Magia selvaggia" -> textViewSottoClasseNascosta.text = getString(R.string.magia_selvaggia_info)
                    "Discendenza draconica" -> textViewSottoClasseNascosta.text = getString(R.string.discendenza_draconica_info)
                    "Il signore fatato" -> textViewSottoClasseNascosta.text = getString(R.string.il_signore_fatato_info)
                    "Il grande antico" -> textViewSottoClasseNascosta.text = getString(R.string.il_grande_antico_info)
                    "L\'immondo" -> textViewSottoClasseNascosta.text = getString(R.string.l_immondo_info)
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
