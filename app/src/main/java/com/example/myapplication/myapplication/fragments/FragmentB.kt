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

class FragmentB : Fragment() {

    companion object {
        fun newInstance() = FragmentB()
    }

    private var callback: OnBackPushed? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        view.findViewById<Button>(R.id.back_btn).setOnClickListener { callback?.onBackPushed() }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as? OnBackPushed
        if(callback == null)
            throw RuntimeException("OnButtonPushed not implemented by activity")
    }
    override fun onDetach() {
        callback = null
        super.onDetach()
    }
    fun onButtonClicked(view: View){
        callback?.onBackPushed()
    }

    interface OnBackPushed{
        fun onBackPushed()
    }
}
