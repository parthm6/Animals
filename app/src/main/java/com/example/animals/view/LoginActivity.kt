package com.example.animals.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.animals.R
import com.example.animals.model.User
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    val user = User("test","test" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login_btn: Button = findViewById(R.id.login_btn)

        login_btn.setOnClickListener(View.OnClickListener {
            var userInput : TextInputEditText = findViewById(R.id.username_et)
            var userId : String = userInput.text.toString()

            var passInput : TextInputEditText = findViewById(R.id.password_et)
            var pass : String = passInput.text.toString()
            checkUser(userId, pass)
        })

    }
    fun checkUser(userId : String, pass : String){
        if(userId == user.user_id && pass == user.password)
        {
            val intent : Intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(baseContext, "Incorrect username or password", Toast.LENGTH_SHORT).show()

        }
    }
}