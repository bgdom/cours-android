package com.example.myapplication.myapplication.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.myapplication.R

class FragmentExempleActivity : AppCompatActivity(), FragmentA.OnButtonPushed, FragmentB.OnBackPushed {
    override fun onBackPushed() {
        super.onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }



    override fun onButtonPushed() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragB = FragmentB.newInstance()
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
        transaction.add(R.id.fragmentContainer, fragB)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_exemple)
    }
}
