package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.shoppingpp_using_retrofit_with_loginform.R
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.datamodels.ProfileInfoSealedClass
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.viewmodels.ProfileViewModel
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {
    private  var fName: EditText ?= null
    private  var lName: EditText ?= null
    private  var mobileNo: EditText?= null
    private  var emailId: EditText?= null
    private var updateBtn: Button?= null
    private var profileViewModel: ProfileViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

         fName = view.findViewById(R.id.et_firstname)
         lName = view.findViewById(R.id.et_lastname)
        emailId = view.findViewById(R.id.et_email)
        mobileNo = view.findViewById(R.id.et_phone)
        updateBtn = view.findViewById(R.id.btn_updater)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        lifecycleScope.launch {
            profileViewModel?.profileInfo?.collect { info ->
                if (info != null && info is ProfileInfoSealedClass.PropertyUpdated) {
                    fName?.setText(info.fName)
                    lName?.setText(info.lName)
                    mobileNo?.setText(info.mobileNo)
                    emailId?.setText(info.emailId)
                }
            }
        }
        updateBtn?.setOnClickListener {
            val fName = fName?.text.toString()
            val lName = lName?.text.toString()
            val mobileNo = mobileNo?.text.toString()
            val emailId = emailId?.text.toString()

            profileViewModel?.updateProfileInfo(fName, lName, mobileNo, emailId)

            Toast.makeText(requireContext(), "Profile information updated successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}


