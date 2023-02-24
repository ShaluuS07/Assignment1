package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.datamodels.MyShoppingDataItem
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.communicators.ApiInterface
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views.BASE_URL
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {
    private val _myShoppingDataFlow: MutableStateFlow<List<MyShoppingDataItem>> = MutableStateFlow(emptyList())
    val myShoppingDataFlow: StateFlow<List<MyShoppingDataItem>> = _myShoppingDataFlow

    init {
        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getMyData()
        retrofitData.enqueue(object : Callback<List<MyShoppingDataItem>?> {
            override fun onResponse(
                call: Call<List<MyShoppingDataItem>?>,
                response: Response<List<MyShoppingDataItem>?>
            ) {
                response.body()?.let {
                    _myShoppingDataFlow.value = it
                }
            }

            override fun onFailure(call: Call<List<MyShoppingDataItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure:" + t.message)
            }
        })
    }
}