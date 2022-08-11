package com.example.tutorial.DagComponents.Producer

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject

//Approach 2 - this class object would be created and inject to where it was called ie. userRegistrationService, no need to manually initialize the object for this class
//class UserRepository  constructor() {
//    fun saveUser( email:String , password : String){
//        Log.d("tutorial","user saved to Database")
//    }
//}


//Approach 4,5  suppose we have requirement of storing the data into some specific database(SQL,Firebase) so we can use this  :
interface UserRepository {
    fun saveUser( email:String , password : String)
}
//Approach 3
class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser( email:String , password : String){
        Log.d("tutorial","user saved to SQL Database")
    }
}

class FirebaseRepository : UserRepository {
    override fun saveUser( email:String , password : String){
        Log.d("tutorial","user saved to Firebase")
    }
}