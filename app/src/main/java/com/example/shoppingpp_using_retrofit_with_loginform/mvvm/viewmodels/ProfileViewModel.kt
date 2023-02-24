package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.viewmodels

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.datamodels.ProfileInfoSealedClass
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val userInfo ="UserInfo"
    private val sharedPreferences: SharedPreferences = application.getSharedPreferences(
        userInfo,
        Context.MODE_PRIVATE
    )

    private val _profileInfo = MutableStateFlow<ProfileInfoSealedClass?>(null)
    val profileInfo: StateFlow<ProfileInfoSealedClass?>
        get() = _profileInfo

    init {
        val fName = sharedPreferences.getString("fName", "")
        val lName = sharedPreferences.getString("lName", "")
        val mobileNo = sharedPreferences.getString("mobileNo", "")
        val emailId = sharedPreferences.getString("emailId", "")

        if (!fName.isNullOrEmpty() && !lName.isNullOrEmpty() && !mobileNo.isNullOrEmpty() && !emailId.isNullOrEmpty()) {
            _profileInfo.value = ProfileInfoSealedClass.PropertyUpdated(fName, lName, mobileNo, emailId)
        }
    }
    fun updateProfileInfo(fName: String, lName: String, mobileNo: String, emailId: String) {
        _profileInfo.value = ProfileInfoSealedClass.PropertyUpdated(fName, lName, mobileNo, emailId)
        sharedPreferences.edit {
            putString("fName", fName)
            putString("lName", lName)
            putString("mobileNo", mobileNo)
            putString("emailId", emailId)
            apply()
        }
    }
}

