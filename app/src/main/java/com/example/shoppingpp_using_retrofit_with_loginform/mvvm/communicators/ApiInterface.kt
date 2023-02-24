package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.communicators

import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.datamodels.MyShoppingDataItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(value = "6b5b438a-a5ec-425d-91d5-ebfb82b27a7e")

    fun getMyData(): Call<List<MyShoppingDataItem>>
}