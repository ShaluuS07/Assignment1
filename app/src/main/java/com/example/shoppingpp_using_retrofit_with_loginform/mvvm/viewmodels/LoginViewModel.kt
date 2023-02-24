package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.viewmodels

import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel: ViewModel() {
    val name = MutableStateFlow<String?>(null)
    val  password = MutableStateFlow<String?>(null)
    private val loginPref = "LoginPref"
    private val userName= "name"
    private val userPassword ="password"

    fun setUserName(names: String) {
        name.value = names
    }

    fun setPassword(name: String) {
        password.value = name
    }

    fun saveUsersData(context: Context) {
        val sharedPreferences = context.getSharedPreferences(loginPref, Context.MODE_PRIVATE)
       sharedPreferences.edit {
            putString(userName, name.value)
            putString(userPassword, password.value)
        }
    }

    fun loadUsersData(context: Context) {
        val sharedPreferences = context.getSharedPreferences(loginPref, Context.MODE_PRIVATE)
        name.value = sharedPreferences.getString(userName, null)
        password.value = sharedPreferences.getString(userPassword, null)

    }


}