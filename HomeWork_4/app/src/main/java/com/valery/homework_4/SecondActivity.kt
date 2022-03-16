package com.valery.homework_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.valery.homework_4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle(R.string.second_activity_title)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, ImageId::class.java)

        binding.secondActivityFirstButton.setOnClickListener {
            setResult(RESULT_OK, intent.putExtra(IMAGE_ID, ImageId.ONE))
            finish()
        }

        binding.secondActivitySecondButton.setOnClickListener {
            setResult(RESULT_OK, intent.putExtra(IMAGE_ID, ImageId.TWO))
            finish()
        }

        binding.secondActivityThirdButton.setOnClickListener {
            setResult(RESULT_OK, intent.putExtra(IMAGE_ID, ImageId.THREE))
            finish()
        }
    }
}