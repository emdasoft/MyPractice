package org.mcalc.mypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.mcalc.mypractice.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    lateinit var binding : ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val key = intent.getIntExtra("key", 100)

        if(key==100){
            binding.txtInLogin.visibility = View.VISIBLE
            binding.txtPwd.visibility = View.VISIBLE
            binding.btnIn.visibility = View.VISIBLE
            binding.btnIn.setOnClickListener{

            val login = binding.txtInLogin.text
            val password = binding.txtPwd.text

            intent.putExtra("login", "$login")
            intent.putExtra("password", "$password")
            setResult(RESULT_OK, intent)
            finish() }
            } else if(key==101){
            binding.txtEnterLogin.visibility = View.VISIBLE
            binding.txtEnterPassword.visibility = View.VISIBLE
            binding.txtEnterFirstName.visibility = View.VISIBLE
            binding.txtEnterLastName.visibility = View.VISIBLE
            binding.btnBack.visibility = View.VISIBLE

            binding.btnBack.setOnClickListener{

               val login = binding.txtEnterLogin.text
               val firstName = binding.txtEnterFirstName.text
               val password = binding.txtEnterPassword.text
               val lastName = binding.txtEnterLastName.text

                intent.putExtra("login", "$login")
                intent.putExtra("password", "$password")
                intent.putExtra("first_name", "$firstName")
                intent.putExtra("last_name", "$lastName")
                setResult(RESULT_OK, intent)
                finish()

            }

        }


    }

}