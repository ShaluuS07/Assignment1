package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.datamodels

sealed class ProfileInfoSealedClass{
    data class PropertyUpdated(
        val fName: String,
        val lName: String,
        val mobileNo: String,
        val emailId : String
    ) : ProfileInfoSealedClass()
}
