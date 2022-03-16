package com.valery.homework_4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.valery.homework_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var currentImageId: String

    private val secondActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let { intent ->
                (intent.getSerializableExtra(IMAGE_ID) as? ImageId)?.value.let { id ->
                    currentImageId = id ?: ImageId.ONE.value
                    binding.mainActivityImageView.setImageResource(
                        resources.getIdentifier(
                            currentImageId,
                            "drawable",
                            this.packageName
                        )
                    )
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle(R.string.main_activity_title)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainActivityButton.setOnClickListener {
            secondActivityLauncher.launch(Intent(this, SecondActivity::class.java))
        }

        currentImageId = savedInstanceState?.getString(IMAGE_ID) ?: ImageId.ONE.value

        binding.mainActivityImageView.setImageResource(
            resources.getIdentifier(
                currentImageId,
                "drawable",
                this.packageName
            )
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(IMAGE_ID, currentImageId)
    }
}