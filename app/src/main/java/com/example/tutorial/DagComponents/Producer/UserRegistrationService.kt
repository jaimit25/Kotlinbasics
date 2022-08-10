package com.example.tutorial.DagComponents.Producer
import com.example.tutorial.DagComponents.Producer.EmailService
import com.example.tutorial.DagComponents.Producer.UserRepository
import javax.inject.Inject



//dagger will automatically Inject object of the  UserRepository and EmailService as both the class have Inject in their constructor

////to create user-registration service object this class needs to be called, and the interface has the declaration for this class
//class UserRegistrationService  @Inject constructor(private val userRepository: UserRepository,
//                                                   private val emailService: EmailService
//) {
//
//
//    fun registerUser(email:String, password : String){
//        userRepository.saveUser(email, password)
//        emailService.send(email,"mail@gmail.com","user registered")
//    }
//
//}


//Approach 5 we will take NotificationService reference instead of EmailService because Notification service is an interface which has implementation of both the class EmailService and MessageService
class UserRegistrationService  @Inject constructor(private val userRepository: UserRepository,
                                                   private val notificationService: NotificationService
) {


    fun registerUser(email:String, password : String){
        userRepository.saveUser(email, password)
        notificationService.send(email,"mail@gmail.com","user registered")
    }

}












// Approach 1 problems in this class
//class UserRegistrationService {
//    private val userRepository : UserRepository = UserRepository()
//    private val emailService : EmailService = EmailService()
//
//
//    fun registerUser(email:String, password : String){
//        userRepository.saveUser(email, password)
//        emailService.send(email,"mail@gmail.com","user registered")
//    }
//
//}
//unit testing -  we need pre-prepared objects of the userrepo and emailservice bcause we are creating object directly in this class
//single responsibility - this class is doing more then 1 task at a time of creating object and registering user as well
//lifetime of object - objects of userRepo and emailService(not re-usable) will destroy when this class object is destroyed
//extensible -  if in future we want to send message instead of mail then we need to create a different object in future for sending messages



