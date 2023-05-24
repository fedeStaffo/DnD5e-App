package com.progetto_dd.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.progetto_dd.R



class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_info, container, false)

        val textView1 = rootView.findViewById<TextView>(R.id.textView1)
        textView1.setOnClickListener {
            val url = "https://github.com/Ems01"
            openUrlInBrowser(url)
        }

        val textView2 = rootView.findViewById<TextView>(R.id.textView2)
        textView2.setOnClickListener {
            val url = "https://github.com/fedeStaffo"
            openUrlInBrowser(url)
        }

        val textView3 = rootView.findViewById<TextView>(R.id.textView3)
        textView3.setOnClickListener {
            val url = "https://github.com/renzialex"
            openUrlInBrowser(url)
        }

        return rootView
    }

    private fun openUrlInBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}