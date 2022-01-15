package com.ndt.imagefilters.repositories

import android.graphics.Bitmap
import android.net.Uri
import com.ndt.imagefilters.data.ImageFilter

interface EditImageRepository {
    suspend fun prepareImagePreview(imageUri: Uri): Bitmap?
    suspend fun getImageFilters(image: Bitmap): List<ImageFilter>
}