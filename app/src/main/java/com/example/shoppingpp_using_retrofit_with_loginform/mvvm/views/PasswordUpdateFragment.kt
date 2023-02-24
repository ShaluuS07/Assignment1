package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views

import android.content.Context
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingpp_using_retrofit_with_loginform.R
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.viewmodels.PasswordUpdateViewModel

class PasswordUpdateFragment : Fragment() {
    private  var viewPagerPasswordViewModel : PasswordUpdateViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_password_update, container, false)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewPagerPasswordViewModel = ViewModelProvider(this)[PasswordUpdateViewModel::class.java]
        viewPagerPasswordViewModel?.sharedPref(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reset = view.findViewById<Button>(R.id.btn_reset)
        val newPassword = view.findViewById<EditText>(R.id.et_newpassword)
        val oldPassword = view.findViewById<EditText>(R.id.et_currentpassword)
        val etPasswordTwo = view.findViewById<EditText>(R.id.et_retypenewpassword)

        newPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        etPasswordTwo.transformationMethod = PasswordTransformationMethod.getInstance()
        oldPassword.transformationMethod = PasswordTransformationMethod.getInstance()

        reset.setOnClickListener {
            val oldPasswords = oldPassword.text.toString()
            val newPasswords = viewPagerPasswordViewModel?.setNewPasswd(newPassword.text.toString())
            val retypedPassword = viewPagerPasswordViewModel?.setRetypePass(etPasswordTwo.text.toString())

            if (retypedPassword != newPasswords) {
                Toast.makeText(activity, R.string.new_pass_and_old_pass, Toast.LENGTH_SHORT).show()
            }

            else if(context?.let { it1 -> viewPagerPasswordViewModel?.sharedPref(it1) } != oldPasswords){
                Toast.makeText(activity, R.string.old_pass, Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(activity, R.string.reset_success, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

