package com.ndt.imagefilters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ndt.imagefilters.databinding.ActivityEditImageBinding

class EditImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditImageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListener()
        displayImagePreview()
    }

    private fun displayImagePreview() {
intent.getParcelableExtra<Uri>(MainActivity.KEY_IMAGE_URI)?.let { imageUri->
    val inputStream = contentResolver.openInputStream(imageUri)
    val bitmap= BitmapFactory.decodeStream(inputStream)
    binding.imagePreview.setImageBitmap(bitmap)
    binding.imagePreview.visibility= View.VISIBLE
}
    }

    private fun setListener() {
        binding.imageBack.setOnClickListener {
            onBackPressed()
        }
    }
}