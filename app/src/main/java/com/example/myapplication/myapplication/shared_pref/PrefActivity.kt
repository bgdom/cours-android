package com.example.myapplication.myapplication.shared_pref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.myapplication.myapplication.R
import kotlinx.android.synthetic.main.activity_pref.*

class PrefActivity : AppCompatActivity() {
    var text: CharSequence? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pref)

        val saved = retrieveSaved()
        savedText.text = savedText.text.toString() + saved

        editText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0 != null) text = p0
            }

        })

        savedBtn.setOnClickListener{ if(text != null) save(text!!) }
    }

    private fun retrieveSaved(): String {
        val pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return pref.getString(TEXT_SAVED, "")!!
    }
    private fun save(text: CharSequence){
        val pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        pref.edit().putString(TEXT_SAVED, text.toString()).apply()
    }

    companion object {
        const val PREF_NAME = "pref"
        const val TEXT_SAVED = "textSaved"
    }
}
