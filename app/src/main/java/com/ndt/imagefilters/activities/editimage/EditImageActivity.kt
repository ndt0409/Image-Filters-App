package com.ndt.imagefilters.activities.editimage

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ndt.imagefilters.activities.main.MainActivity
import com.ndt.imagefilters.databinding.ActivityEditImageBinding
import com.ndt.imagefilters.utilities.displayToast
import com.ndt.imagefilters.utilities.show
import com.ndt.imagefilters.viewmodels.EditImageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditImageBinding

    private val viewModel: EditImageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditImageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListener()
        setupObservers()
        prepareImagePreview()
    }

    private fun setupObservers(){
        viewModel.emitImagePreviewUiState.observe(this, {
            val dataState=it ?: return@observe
            binding.previewProgressBar.visibility = if (dataState.isLoading) View.VISIBLE else View.GONE
            dataState.bitmap?.let { bitmap ->
                binding.imagePreview.setImageBitmap(bitmap)
                binding.imagePreview.show()
            }?:kotlin.run {
                dataState.error?.let { error->
                    displayToast(error)
                }
            }
        })
    }
    private fun prepareImagePreview(){
        intent.getParcelableExtra<Uri>(MainActivity.KEY_IMAGE_URI)?.let { imageUri ->
            viewModel.prepareImagePreview(imageUri)
        }
    }

    private fun setListener() {
        binding.imageBack.setOnClickListener {
            onBackPressed()
        }
    }
}