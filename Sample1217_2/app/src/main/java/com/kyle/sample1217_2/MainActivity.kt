package com.kyle.sample1217_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var text1 : TextView
    lateinit var switch1: Switch
    lateinit var rGroup1 : RadioGroup
    var radioArray = ArrayList<RadioButton>(3) // ArrayList 배열의 길이(length) 3이다.
    lateinit var imgAni : ImageView
    lateinit var btnQuit : Button
    lateinit var btnReset : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switch1 = findViewById<View>(R.id.switch1) as Switch
        text1 = findViewById<View>(R.id.text1) as TextView
        rGroup1 = findViewById<View>(R.id.radGroup1) as RadioGroup
        radioArray.add(findViewById<View>(R.id.rdoDog) as RadioButton)
        radioArray.add(findViewById<View>(R.id.rdoCat) as RadioButton)
        radioArray.add(findViewById<View>(R.id.rdoBird) as RadioButton)

        imgAni = findViewById<View>(R.id.imgAni) as ImageView

        btnQuit = findViewById<View>(R.id.btnQuit) as Button
        btnReset = findViewById<View>(R.id.btnReset) as Button


        switch1.setOnCheckedChangeListener{ compoundButton, b ->
            if(switch1.isChecked == true){
                text1.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                imgAni.visibility = android.view.View.VISIBLE
                btnQuit.visibility = android.view.View.VISIBLE
                btnReset.visibility = android.view.View.VISIBLE
            }else{
                text1.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                imgAni.visibility = android.view.View.INVISIBLE
                btnQuit.visibility = android.view.View.INVISIBLE
                btnReset.visibility = android.view.View.INVISIBLE
            }
        }

        val draw = intArrayOf(R.drawable.dog1, R.drawable.cat1, R.drawable.bird1)
        for (i in radioArray.indices){
            radioArray[i].setOnClickListener(View.OnClickListener {
                imgAni.setImageResource(draw[i])
            })
        }

        btnQuit.setOnClickListener{ finish() }

        btnReset.setOnClickListener {
            text1.visibility = android.view.View.INVISIBLE
            rGroup1.visibility = android.view.View.INVISIBLE
            imgAni.visibility = android.view.View.INVISIBLE
            btnQuit.visibility = android.view.View.INVISIBLE
            btnReset.visibility = android.view.View.INVISIBLE

            rGroup1.clearCheck() // check한 것은 초기화 시켜라
            switch1.isChecked = false
            }
        }
    }