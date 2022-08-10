package com.example.tutorial.DagComponents.Producer

import android.util.Log
import javax.inject.Inject

//Approach 1,2,3
//this class object would be created and inject to where it was called ie. userRegistrationService
//class EmailService @Inject constructor() {
//    fun send(to:String , from:String, body:String){
//        Log.d("tutorial","Email Sent")
//    }
//}



//Approach 4 suppose we have have to send message and not email so we will use interface NotificationService and also we will create object of that class(NotificationService and not EmailService)
interface NotificationService {
    fun send(to:String , from:String, body:String?)
}

class EmailService @Inject constructor() :NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d("tutorial","Email Sent")
    }
}

class MessageService : NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d("tutorial","Email Sent")
    }

}