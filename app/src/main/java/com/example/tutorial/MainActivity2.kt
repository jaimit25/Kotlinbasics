package com.example.tutorial
//https://stackoverflow.com/questions/33982437/can-someone-provide-a-good-explanation-of-dagger-2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tutorial.DagComponents.Component.DaggeruserRegistrationComponent
import com.example.tutorial.DagComponents.Producer.EmailService
import com.example.tutorial.DagComponents.Producer.UserRegistrationService
import com.example.tutorial.DagComponents.Producer.UserRepository
import javax.inject.Inject

//this page is the consumer page for Dagger
class MainActivity2 : AppCompatActivity() {

    @Inject //Approach 3 use this annotation - dagger will know we have to inject into this fields and we don't need to manually initialise this userRegistrationService2 object
    lateinit var userRegistrationService2 : UserRegistrationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        //# - Approach 1 without using dagger and simply creating object manually
        // if we want userRegistrationService once again then we have to create object of these two class again so we use dagger2 instead
        //var userRepo : UserRepository =  UserRepository()
        //var emailService : EmailService =  EmailService()
        //val userRegistrationService =  UserRegistrationService(userRepo, emailService )
        //userRegistrationService.registerUser("mail@gmail.com", "12345678")



        ////# - Approach 2  using dagger and for every dependency we have created variable ie. userRegistrationService and emailService
        ////Component : this is use to create the component for Depedency injections ->    "Dagger$InterfaceComponentName.builder().build()"
        // val component =  DaggeruserRegistrationComponent.builder().build()
        //
        ////dependencies : this will give userRegistrationService Object :  DaggeruserRegistrationComponent.builder().build().getUserRegistrationService()
        //val userRegistrationService : UserRegistrationService = component.getUserRegistrationService() // DaggeruserRegistrationComponent =>   Dagger  + userRegistrationComponent => Dagger word was automatically appended by dagger2
        //
        ////dependencies : this will give emailService object :  DaggeruserRegistrationComponent.builder().build().getEmailService()
        //val emailService:EmailService = component.getEmailService()
        //userRegistrationService.registerUser("mail@gmail.com", "12345678")




//        //# - Approach 3,4,5 using @Inject annotation with fields/variable
         val component =  DaggeruserRegistrationComponent.builder().build() // we have the component now
         component.injectDep(this)
         userRegistrationService2.registerUser("mail@gmail.com", "12345678")


    }



}


















//@Module: Modules are classes whose methods provide
// dependencies, so we define a class and annotate
// it with @Module, thus, Dagger will know where to
// find the dependencies in order to satisfy them
// when constructing class instances. One important
// feature of modules is that they have been designed
// to be partitioned and composed together (for instance
// we will see that in our apps we can have multiple composed modules).

//@Component: Components basically are injectors,
// let’s say a bridge between @Inject and @Module,
// which its main responsibility is to put both together.
// They just give you instances of all the types you defined,
// for example, we must annotate an interface with @Component
// and list all the @Modules that will compose that component,
// and if any of them is missing, we get errors at compile time.
// All the components are aware of the scope of dependencies it
// provides through its modules.

//@Provide: Inside modules we define methods containing this
// annotation which tells Dagger how we want to construct and
// provide those mentioned dependencies.