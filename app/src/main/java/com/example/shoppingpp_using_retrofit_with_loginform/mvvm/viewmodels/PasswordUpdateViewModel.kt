package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.StateFlow

class PasswordUpdateViewModel : ViewModel() {
    private var _newPasswd = MutableStateFlow("")
    var newPassword : StateFlow<String> = _newPasswd
    var _oldPasswd = MutableStateFlow("")
    var oldPassword : StateFlow<String> = _oldPasswd
    private var _retypePasswd = MutableStateFlow("")
    var retypePasswd : StateFlow<String> = _retypePasswd

    private val passwd = "password"
    private val loginPref = "LoginPref"

    fun setOldPasswd(oldPasswd : String){
        _oldPasswd.value = oldPasswd
    }

    fun setNewPasswd(newPass : String){
        _newPasswd.value = newPass
    }
    fun setRetypePass(retypePass : String){
        _retypePasswd.value = retypePass
    }

    fun sharedPref(context: Context) : String? {
        val sharedPreferences = context.getSharedPreferences(loginPref, Context.MODE_PRIVATE)
        return sharedPreferences?.getString(passwd, "")
    }
}

