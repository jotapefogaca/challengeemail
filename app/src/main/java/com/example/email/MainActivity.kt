package com.example.email

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.email.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var emailAdapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setupRecyclerView()
    }


    private fun setupRecyclerView() {
        emailAdapter = EmailAdapter(getEmails())
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = emailAdapter
        }
    }

    private fun getEmails(): List<Email> {
        // Aqui você pode buscar emails de uma API ou banco de dados
        return listOf(
            Email("Pessoa 1", "Asssunto", "mensagem "),
            Email("Pessoa 2", "Assunto", "mensagem"),
            Email("Pessoa 3", "Assunto", "mensagem")
        )
    }
}

