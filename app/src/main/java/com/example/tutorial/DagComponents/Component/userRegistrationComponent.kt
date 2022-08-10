package com.example.tutorial.DagComponents.Component
import com.example.tutorial.DagComponents.Producer.EmailService
import com.example.tutorial.DagComponents.Producer.Modules.notificationServiceModule
import com.example.tutorial.DagComponents.Producer.Modules.userRepositoryModule
import com.example.tutorial.DagComponents.Producer.UserRegistrationService
import com.example.tutorial.MainActivity2
import dagger.Component


//@Component
//interface userRegistrationComponent {
//
//    //Approach 2  :dependency : this class will return userRegistrationService object
//    fun getUserRegistrationService()  : UserRegistrationService;
//
//    //Approach 2 : dependency : this class will return EmailService object
//    fun getEmailService(): EmailService
//
//
//    //Approach 3 : if we have Multiple dependencies then this approach of creating manually is not good so we can use this (name could be any injectDepen...)
//    fun injectDep(mainActivity2: MainActivity2) // mainActivity2 is our consumer , also above 2 method we can comment or remove
//
//    //Approach 4 suppose we have have to send message and not email so we will use interface NotificationService and also we will create object of that class
//
//
//}


//Approach 5 - which notificationservice to call and which repository to use
//modules = [userRepositoryModule::class,notificationServiceModule::class => this will tell components about which modules we have
@Component(modules = [userRepositoryModule::class,notificationServiceModule::class])
interface userRegistrationComponent {

    //Approach 3,4,5 : if we have Multiple dependencies then this approach of creating manually is not good so we can use this (name could be any injectDepen...)
    //Approach 4 suppose we have have to send message and not email so we will use interface NotificationService and also we will create object of that class

    fun injectDep(mainActivity2: MainActivity2) // mainActivity2 is our consumer , also above 2 method we can comment or remove



}













//structure
//     email,userRepository,UserRegistrationService (producer class - @Inject annotation)
//                            |
//            UserRegistrationServiceComponent(component interface - @Component annotation)
//                      (interface)
//                            |
//                   mainActivity2 (consumer)


//Note : this class don't create object it just pass the object after creating(using Inject keyword annotation).
