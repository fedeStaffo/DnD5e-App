package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentResetPasswordBinding
import com.progetto_dd.memory.campagna.CampagnaViewModel


class ResetPasswordFragment : Fragment() {

    private var _binding: FragmentResetPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il ViewModel
        val viewModel = ViewModelProvider(this).get(CampagnaViewModel::class.java)

        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
        val masterId = requireActivity().intent.getStringExtra("master_id")

        var oldPassw: String? = null
        if (campagnaNome != null && masterId != null) {
            viewModel.getPasswordByCampagna(campagnaNome, masterId).observe(viewLifecycleOwner) { password ->
                oldPassw = password
                binding.oldPasswordTextView.text = oldPassw
            }
        }

        binding.oldPasswordTextView.text = oldPassw.toString()

        binding.btnResetPassword.setOnClickListener {
            val oldPassword = binding.oldPasswordTextView.text.toString()
            val newPassword = binding.passET.text.toString()
            val confirmPassword = binding.confPassET.text.toString()

            if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(requireContext(),"Inserisci una nuova password e conferma password", Toast.LENGTH_SHORT).show()
            } else if (newPassword != confirmPassword) {
                Toast.makeText(requireContext(),"La nuova password e la conferma password non corrispondono", Toast.LENGTH_SHORT).show()
            } else {
                val dialog = AlertDialog.Builder(requireContext())
                    .setTitle("Cambia Password")
                    .setMessage("Sei sicuro di voler cambiare la password?")
                    .setPositiveButton("Conferma") { _, _ ->
                        if (campagnaNome != null) {
                            if (masterId != null) {
                                viewModel.updateCampagnaPassword(campagnaNome, masterId, confirmPassword)
                                findNavController().navigate(R.id.action_resetPasswordFragment_to_visualizzaCampagnaFragment)
                            }
                        }
                    }
                    .setNegativeButton("Annulla", null)
                    .create()

                dialog.show()
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}