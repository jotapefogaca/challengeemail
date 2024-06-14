package com.example.email
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.email.MainActivity
import com.example.email.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura o botão de login para iniciar a MainActivity
        binding.loginButton.setOnClickListener {
            // Cria um Intent para iniciar a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // Fecha a LoginActivity para que o usuário não possa voltar para ela pressionando o botão Voltar
            finish()
        }
    }
}
