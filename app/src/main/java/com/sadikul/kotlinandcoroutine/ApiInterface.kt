package com.sadikul.kotlinandcoroutine

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET
    fun getData(@Url url: String): Call<ResponseBody>
}
