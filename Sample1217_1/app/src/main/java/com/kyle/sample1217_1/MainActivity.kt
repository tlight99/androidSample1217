package com.kyle.sample1217_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var text1 : TextView
    lateinit var chkAgree : CheckBox
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoBird : RadioButton
    lateinit var btnOk : Button
    lateinit var imgAni : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chkAgree = findViewById<CheckBox>(R.id.chk1)
        text1 = findViewById<TextView>(R.id.text1)
        rGroup1 = findViewById<RadioGroup>(R.id.radGroup1)
        rdoDog = findViewById<RadioButton>(R.id.rdoDog)
        rdoCat = findViewById<RadioButton>(R.id.rdoCat)
        rdoBird = findViewById<RadioButton>(R.id.rdoBird)

        btnOk = findViewById<Button>(R.id.btnOk)
        imgAni = findViewById<ImageView>(R.id.imgAni)

        chkAgree.setOnCheckedChangeListener{ compoundButton, b ->
            if(chkAgree.isChecked == true){
                text1.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnOk.visibility = android.view.View.VISIBLE
                imgAni.visibility = android.view.View.VISIBLE
            }else{
                text1.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnOk.visibility = android.view.View.INVISIBLE
                imgAni.visibility = android.view.View.INVISIBLE
            }
        }

        btnOk.setOnClickListener {
            when(rGroup1.checkedRadioButtonId) {
                R.id.rdoDog -> imgAni.setImageResource(R.drawable.dog)
                R.id.rdoCat -> imgAni.setImageResource(R.drawable.cat)
                R.id.rdoBird -> imgAni.setImageResource(R.drawable.bird)
                else -> Toast.makeText(applicationContext, "선택을 먼저 해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}