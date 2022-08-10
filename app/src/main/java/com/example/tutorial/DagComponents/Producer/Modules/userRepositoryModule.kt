package com.example.tutorial.DagComponents.Producer.Modules

import com.example.tutorial.DagComponents.Producer.FirebaseRepository
import com.example.tutorial.DagComponents.Producer.UserRepository
import dagger.Module
import dagger.Provides
//only "1" function/method we will have in this class with @provides annotation
@Module // Approach 5 this annotation will tell which class to use if interface has multiple implementations
class userRepositoryModule {

    @Provides // this will provide the object if we have to choose from multiple interface - class implementation ie firebasrepo or sqlrepo
    fun getFirebaseUserRepository() :UserRepository{
        return FirebaseRepository()//this object will be returned when this module will be called
    }

}