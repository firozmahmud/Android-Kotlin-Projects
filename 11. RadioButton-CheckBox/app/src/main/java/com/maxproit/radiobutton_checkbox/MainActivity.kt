package com.maxproit.radiobutton_checkbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        // radio group change listener
        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                if (checkedId == -1) {
                    radioBtnResult.text = "Please select any option"
                } else {
                    var radioBtn = findViewById<RadioButton>(checkedId)
                    radioBtnResult.text = "You select ${radioBtn.text}"
                }
            }

        })

        // checkbox change listener
        cbAfridi.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                checkCheckBoxChange()
            }
        })

        cbChrisGayle.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                checkCheckBoxChange()
            }
        })

        cbABdeVilliers.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                checkCheckBoxChange()
            }

        })

    }

    private fun checkCheckBoxChange() {
        var sb = StringBuilder("")
        sb.append("You select ")
        if (cbAfridi.isChecked) sb.append("Afridi, ")
        if (cbChrisGayle.isChecked) sb.append("Gayle, ")
        if (cbABdeVilliers.isChecked) sb.append("Villiers, ")

        sb.deleteCharAt(sb.length-2)
        checkBoxResultTv.text = sb
    }
}
