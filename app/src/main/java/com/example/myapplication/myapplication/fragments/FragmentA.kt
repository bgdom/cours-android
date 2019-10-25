package com.example.myapplication.myapplication.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.myapplication.R
import java.lang.RuntimeException

class FragmentA : Fragment() {

    companion object { fun newInstance() = FragmentA() }

    private var callback : OnButtonPushed? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_a, container, false)
        view.findViewById<Button>(R.id.go_btn).setOnClickListener { callback?.onButtonPushed() }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? OnButtonPushed
        if(callback == null)
            throw RuntimeException("OnButtonPushed not implemented by activity")
    }

    override fun onDetach() {
        callback = null
        super.onDetach()
    }

    interface OnButtonPushed {
        fun onButtonPushed()
    }
}
