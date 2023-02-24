package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.shoppingpp_using_retrofit_with_loginform.R
import com.example.shoppingpp_using_retrofit_with_loginform.R.*
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views.LoginFragment
import com.google.android.material.imageview.ShapeableImageView

const val BASE_URL = "https://mocki.io/v1/"

class MainActivity : AppCompatActivity() {
    private val image = "img"
    private val productDescription = "prd_description"
    private var fragmentLogin: LoginFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val fragmentLogin = LoginFragment()
        supportFragmentManager.beginTransaction().replace(id.container, fragmentLogin).commit()
    }

    fun callBackToActivity(img: String?, prd_description: String?) {
        Log.d("image1", "$img")
        val bundle = Bundle()
        bundle.apply {
            putString(image, img)
            putString(productDescription, prd_description)
        }
        val productDescriptionFragment = ProductDescriptionFragment()
        productDescriptionFragment.arguments = bundle
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(id.container, productDescriptionFragment)
        fragmentLogin = LoginFragment()
        val backStateName = fragmentLogin?.javaClass?.name
        fragmentTransaction.addToBackStack(backStateName)
        fragmentTransaction.commit()

    }
}

class ProductDescriptionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val imagePrd: ShapeableImageView
        val prdDesc : TextView
        val view = inflater.inflate(layout.fragment_product_description, container, false)
        imagePrd = view.findViewById(R.id.action_image)
        prdDesc = view.findViewById(R.id.prdDescription)
        val data = arguments
        val productDescription = data?.getString("prd_description")
        prdDesc.text = productDescription
        val imageV = data?.getString("img")
        context?.let {
            Glide.with(it)
                .load(imageV)
                .into(imagePrd)
        }
        return view
    }


}