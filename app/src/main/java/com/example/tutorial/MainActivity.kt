package com.example.tutorial

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.tutorial.Pages.ReviewPage
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    //initializing variable outside the oncreate method
    lateinit var toast : Toast
    lateinit var toast2 : Toast
    lateinit var textView : TextView
    lateinit var savebtn : Button
    lateinit var startbtn : Button
    lateinit var stopBtn : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing display view
        textView =  findViewById(R.id.title_page);
        savebtn=  findViewById(R.id.save);
        stopBtn = findViewById(R.id.stop);

        //initializing toast
        toast = Toast.makeText(this, "Welcome User", Toast.LENGTH_SHORT)
        toast2 = Toast.makeText(this, "Clicked Back button", Toast.LENGTH_SHORT)

        //initializing intent
        var intent : Intent = Intent(this, ReviewPage::class.java)


        //send data to other page using bundle since consturtor dosen't work
        var bun : Bundle = Bundle()
        bun.putString("name","hotmarty")
        intent.putExtras(bun)



        //using timer
        Timer().schedule(5000) {
            //displaying toast
            toast.show();

            //making visibility off
            textView.visibility = TextView.INVISIBLE;

            //updating the UI on different thread leads to the error so we need to update it on the mainUI thread using runOnUiThread function
            runOnUiThread(Runnable {
                textView.text = "Welcome".toString()
                textView.visibility = TextView.VISIBLE;

            //store User Details in shared prefs background
                saveData()
            })
        }

        //reacting to events
        savebtn.setOnClickListener(View.OnClickListener {
            //it will send data in bundle as well to different page
            startActivity(intent)

            //this will destory the current activity and it will no longer be in the memory stack
            //finish()
        });
    }


    //shared preferences
    private fun saveData(){
        //we will need shared prefrences variable and an editor which will edit things
         val prefs : SharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
         val editor : SharedPreferences.Editor = prefs.edit()
        editor.apply{
            putString("phone",getNum().toString())
        }.apply()
    }


    //get User Phone Number
    fun getNum() : Int{
        return 123;
    }

    // overiding backbutton
    override fun onBackPressed() {
        super.onBackPressed()
        toast2.show()
    }





}
