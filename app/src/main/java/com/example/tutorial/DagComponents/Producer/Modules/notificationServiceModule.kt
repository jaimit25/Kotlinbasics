package com.example.tutorial.DagComponents.Producer.Modules

import com.example.tutorial.DagComponents.Producer.FirebaseRepository
import com.example.tutorial.DagComponents.Producer.MessageService
import com.example.tutorial.DagComponents.Producer.NotificationService
import com.example.tutorial.DagComponents.Producer.UserRepository
import dagger.Module
import dagger.Provides
//automaticlly - MessageService will be sent and not email service and also only "1" function/method we will have in this class with @provides annotation
@Module // Approach 5 this annotation will tell which class to use if interface has multiple implementations ie. email and message service
class notificationServiceModule {

    @Provides
    fun getMessageService() : NotificationService {
        return MessageService()//this object will be returned when this module will be called
    }

}