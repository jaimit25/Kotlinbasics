package com.example.tutorial.Pages

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tutorial.R


// Getting Data from Shared prefrences and Bundle
class ReviewPage : AppCompatActivity() {

    lateinit var textView_name: TextView; // data from Bundle
    lateinit var textView_num: TextView; // data from SharedPrefrences
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_page)

        //initializing the views
        textView_name = findViewById(R.id.name)
        textView_num = findViewById(R.id.num)


        //initialing bundle variable and get the extra(data) from the bundle which was passed into intent
        val b = intent.extras
        if (b != null) {
            setData(b)
        }


        //get data from shared prefs
        pref = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        runOnUiThread(Runnable {
            var number: String? = pref.getString("phone", "phone")
            if(number != null)
                textView_num.text = number.toString()
            else
                textView_num.text = "NULL"
        })

    }

    //function for getting data from extra in intent and displaying in the TextView if its not NULL
    fun setData(b : Bundle){
        var value :String = "Name"
        if (b != null) value = b.getString("name").toString()
        if(b != null)
            textView_name.setText(value)
        else
            textView_name.setText("name is null")
    }

    override fun onBackPressed() {
        super.onBackPressed()

        //this will destroy the activity
        finish()
    }

}