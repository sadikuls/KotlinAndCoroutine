package com.sadikul.kotlinandcoroutine

import android.app.Application

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient : Application() {
    companion object {
        fun getRetrofitClient(): Retrofit {
            return Retrofit.Builder().baseUrl(Constant.BASE_URL)
                .client(provideOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(
                    GsonConverterFactory.create()
                ).build()
        }

        private fun provideOkHttpClient(): OkHttpClient {
            val okhttpClientBuilder = OkHttpClient.Builder()
            okhttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS)
            okhttpClientBuilder.readTimeout(10, TimeUnit.SECONDS)
            okhttpClientBuilder.writeTimeout(10, TimeUnit.SECONDS)
            //okhttpClientBuilder.addInterceptor(new AuthorizationInterceptor());
            return okhttpClientBuilder.build()
        }

        fun getApiInterface(): ApiInterface {
            return getRetrofitClient().create(ApiInterface::class.java)
        }
    }
}
