package com.ndt.imagefilters.dependencyinjection

import com.ndt.imagefilters.repositories.EditImageRepository
import com.ndt.imagefilters.repositories.EditImageRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<EditImageRepository> { EditImageRepositoryImpl(androidContext()) }
}