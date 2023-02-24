package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingpp_using_retrofit_with_loginform.*
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.communicators.CallBackToFragmentListener
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.viewmodels.HomeViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() , CallBackToFragmentListener {
    private var homeViewModel: HomeViewModel?= null
    private var recyclerViewAdapter: ShoppingListRecyclerViewAdapter? = null
    private var recyclerView: RecyclerView ? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view_item)
        homeViewModel = HomeViewModel()

        lifecycleScope.launch {
            homeViewModel!!.myShoppingDataFlow.collect { myShoppingData ->
                recyclerViewAdapter = ShoppingListRecyclerViewAdapter(myShoppingData)
                recyclerViewAdapter?.setCallBackListener(this@HomeFragment)
                recyclerView?.layoutManager = LinearLayoutManager(context)
                recyclerView?.setHasFixedSize(true)
                recyclerView?.adapter = recyclerViewAdapter
            }
        }
        val profileUpdate = view.findViewById<Button>(R.id.btn_viewpager)
        profileUpdate.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val viewPagerFragment = ViewPagerFragment()
            transaction?.replace(R.id.container, viewPagerFragment)
            val backStateName = LoginFragment::class.java.name
            transaction?.addToBackStack(backStateName)
            transaction?.commit()
        }
        Log.d("ShoppingListFragment", "onViewCreated")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun callBack(img: String?, prd_description:String?) {
        Log.d("prd_description","$prd_description")
        Log.d("img","$img")
        (activity as MainActivity).callBackToActivity(img,prd_description)
    }

}

