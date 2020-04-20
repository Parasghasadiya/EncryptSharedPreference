package com.encryptpref.example

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.encryptpreference.EncPref
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private val PREF_KEY_TEXT = "KEY_TEXT"
        private val PREF_KEY_NUMBER = "KEY_NUMBER"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSavedText()
        btnSaveText.setOnClickListener(this)
        btnSaveNumber.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSaveText -> {
                saveText()
            }
            R.id.btnSaveNumber -> {
                saveNumber()
            }
        }
    }

    private fun getSavedText() {
        tvText.text = EncPref.getString(PREF_KEY_TEXT,getString(R.string.message_no_data_found))
        tvNumber.text = String.format("%s", EncPref.getDouble(PREF_KEY_NUMBER))
        Log.d("ALL_VALUE", EncPref.getAll().toString())
    }

    private fun saveText() {
        if (edtText.text.toString().trim().isNotEmpty()) {
            EncPref.putString(PREF_KEY_TEXT, edtText.text.toString().trim())
            getSavedText()
        } else {
            Snackbar.make(rootLayout, getString(R.string.message_enter_text), Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    private fun saveNumber() {
        if (edtNumber.text.toString().trim().isNotEmpty()) {
            EncPref.putDouble(PREF_KEY_NUMBER, edtNumber.text.toString().trim().toDouble())
            getSavedText()
        } else {
            Snackbar.make(
                rootLayout,
                getString(R.string.message_enter_number),
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

}
