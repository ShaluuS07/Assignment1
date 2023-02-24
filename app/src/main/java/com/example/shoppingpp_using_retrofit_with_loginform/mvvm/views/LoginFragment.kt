package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingpp_using_retrofit_with_loginform.R
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.viewmodels.LoginViewModel

class LoginFragment : Fragment() {
    private var loginViewModel: LoginViewModel?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = layoutInflater.inflate(R.layout.fragment_login, container, false)

     loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val userName = rootView.findViewById<EditText>(R.id.et_name)
        val signupBtn = rootView.findViewById<Button>(R.id.btn_signup)
        val password = rootView.findViewById<EditText>(R.id.et_password)
        val checkBox = rootView.findViewById<CheckBox>(R.id.remember_checkbox)
        password.transformationMethod = PasswordTransformationMethod.getInstance()

        loginViewModel?.loadUsersData(requireContext())

        userName.setText(loginViewModel?.name?.value)
        password.setText(loginViewModel?.password?.value)

        signupBtn.setOnClickListener {
          loginViewModel?.setUserName(userName.text.toString())
           loginViewModel?.setPassword(password.text.toString())

            loginViewModel?.saveUsersData(requireContext())

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val homeFragment = HomeFragment()
            transaction?.replace(R.id.container, homeFragment)
            transaction?.commit()

            userName.visibility = View.GONE
            password.visibility = View.GONE
            signupBtn.visibility = View.GONE
            checkBox.visibility = View.GONE


        }

        return rootView
    }
}
