package edu.temple

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pass = findViewById<EditText>(R.id.password)
        val check_pass = findViewById<EditText>(R.id.password_check)
        val uname = findViewById<EditText>(R.id.username)
        val email_addr = findViewById<EditText>(R.id.email)
        val str_to_regex = ""
        val regexed = str_to_regex.toRegex()
        findViewById<Button>(R.id.submission).setOnClickListener{
            when {
                pass.text.toString() != check_pass.text.toString() -> {
                    pass.setError("The passwords do not match")
                    val err = pass.error.toString()
                    val myToast = Toast.makeText(this,err,Toast.LENGTH_SHORT)
                    myToast.show()
                }
                check_pass.text.toString().matches(regexed) -> {
                    check_pass.setError("Nothing was entered for the password check")
                    val err2 = check_pass.error.toString()
                    val myToast = Toast.makeText(this,err2,Toast.LENGTH_SHORT)
                    myToast.show()
                }
                uname.text.toString().matches(regexed) -> {
                    uname.setError("Nothing was entered for the username")
                    val err3 = uname.error.toString()
                    val myToast = Toast.makeText(this,err3,Toast.LENGTH_SHORT)
                    myToast.show()
                }
                email_addr.text.toString().matches(regexed) -> {
                    email_addr.setError("Nothing was entered for the username")
                    val err4 = email_addr.error.toString()
                    val myToast = Toast.makeText(this,err4,Toast.LENGTH_SHORT)
                    myToast.show()
                }
                else -> {
                    val name = uname.text.toString()
                    val message = "Thank you for signing in"
                    val final_message = message.plus(" ").plus(name)
                    val myToast = Toast.makeText(this,final_message,Toast.LENGTH_SHORT)
                    myToast.show()
                }
            }
        }
    }
}
