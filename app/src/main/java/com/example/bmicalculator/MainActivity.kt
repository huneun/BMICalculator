package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        val resultButton: Button = findViewById(R.id.resultButton)

        resultButton.setOnClickListener{
            Log.d("MainActivity", "ResultButton이 클릭되었습니다.")

            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_LONG).show()
                return@setOnClickListener //어디를 나갈것인지 명시하는 어노테이션
            }

            //이 아래로는 절대 빈값이 올수 없음.
                val height: Int = heightEditText.text.toString().toInt()
                val weight: Int = weightEditText.text.toString().toInt()
            Log.d("MainActivity","height: $height weight: $weight")

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)
        }

    }
}