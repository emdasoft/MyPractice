package org.mcalc.mypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.mcalc.mypractice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var login : String
    lateinit var firstName : String
    lateinit var password : String
    lateinit var lastName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 101 && resultCode == RESULT_OK && data != null) {
            login = data.getStringExtra("login").toString()
            password = data.getStringExtra("password").toString()
            firstName = data.getStringExtra("first_name").toString()
            lastName = data.getStringExtra("last_name").toString()

            binding.btnSignIn.visibility = View.GONE
            binding.btnSignUp.visibility = View.GONE
            binding.txtLogin.visibility = View.VISIBLE
            binding.txtFirstName.visibility = View.VISIBLE
            binding.txtLastName.visibility = View.VISIBLE
            binding.btnExit.visibility = View.VISIBLE
            binding.txtLogin.text = login
            binding.txtFirstName.text = firstName
            binding.txtLastName.text = lastName
        }
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            val tempLogin = data.getStringExtra("login").toString()
            val tempPassword = data.getStringExtra("password").toString()
            try{
                if (tempLogin == login && tempPassword == password) {
                binding.btnSignIn.visibility = View.GONE
                binding.btnSignUp.visibility = View.GONE
                binding.txtLogin.visibility = View.VISIBLE
                binding.txtFirstName.visibility = View.VISIBLE
                binding.txtLastName.visibility = View.VISIBLE
                binding.btnExit.visibility = View.VISIBLE
                binding.txtLogin.text = login
                binding.txtFirstName.text = firstName
                binding.txtLastName.text = lastName
            } else {
                binding.txtLogin.visibility = View.VISIBLE
                binding.txtLogin.text = "${resources.getText(R.string.error_sign_in)}"
            }
            } catch (e: Exception){
                binding.txtLogin.visibility = View.VISIBLE
                val errorText = "${resources.getText(R.string.error_no_user)}"
                binding.txtLogin.text = errorText
            }
        }
    }
    fun onClickSignIn(view: View){
        val intent = Intent(this, FirstActivity::class.java)
        intent.putExtra("key", 100)
        startActivityForResult(intent, 100)
    }

    fun onClickSignUp(view: View){
        val intent = Intent(this, FirstActivity::class.java)
        intent.putExtra("key", 101)
        startActivityForResult(intent, 101)
    }

    fun onClickExit(view: View) {
        binding.btnSignIn.visibility = View.VISIBLE
        binding.btnSignUp.visibility = View.VISIBLE
        binding.txtLogin.visibility = View.GONE
        binding.txtFirstName.visibility = View.GONE
        binding.txtLastName.visibility = View.GONE
        binding.btnExit.visibility = View.GONE
    }
}