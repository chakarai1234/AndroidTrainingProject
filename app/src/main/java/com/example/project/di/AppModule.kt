package com.example.project.di

import android.content.Context
import com.example.project.BuildConfig
import com.example.project.api.JsonApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
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
    
    @Provides
    @Singleton
    fun provideBaseUrl() = "https://jsonplaceholder.typicode.com/"
    
    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()
    
    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        
        val requestInterceptor = Interceptor {
            val url = it.request().url.newBuilder().build()
            val request = it.request().newBuilder().url(url).build()
            return@Interceptor it.proceed(request)
        }
        
        OkHttpClient.Builder().addInterceptor(requestInterceptor).addInterceptor(loggingInterceptor).readTimeout(Duration.ofMinutes(1))
            .build()
        
    } else {
        OkHttpClient.Builder().readTimeout(Duration.ofMinutes(1)).build()
    }
    
    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, gson: Gson, client: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(baseUrl).client(client).baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build()
    
    
    @Provides
    @Singleton
    fun provideJsonApi(retrofit: Retrofit): JsonApi = retrofit.create(JsonApi::class.java)
    
}
