package com.example.project.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    @Named("applicationName")
    fun provideApplicationName(@ApplicationContext context: Context): String {
        return context.applicationInfo.loadLabel(context.packageManager).toString()
    }
    
}
