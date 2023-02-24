package com.example.shoppingpp_using_retrofit_with_loginform.mvvm.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.datamodels.MyShoppingDataItem
import com.example.shoppingpp_using_retrofit_with_loginform.R
import com.example.shoppingpp_using_retrofit_with_loginform.mvvm.communicators.CallBackToFragmentListener
import com.google.android.material.imageview.ShapeableImageView
class ShoppingListRecyclerViewAdapter( private var userList: List<MyShoppingDataItem>):
    RecyclerView.Adapter<ShoppingListRecyclerViewAdapter.ViewHolder>(){
    private var mCallBackToFragmentListener : CallBackToFragmentListener?= null
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var prdName : TextView
        var prdPrice : TextView
        var img : ShapeableImageView
        var itemViewLayout :ConstraintLayout
        init {
            prdName = itemView.findViewById(R.id.tv_product_name)
            prdPrice = itemView.findViewById(R.id.tv_product_price)
            img = itemView.findViewById(R.id.title_image)
            itemViewLayout = itemView.findViewById(R.id.item_layout)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = userList[position]
        Glide.with(holder.itemView.context)
            .load(dataItem.img)
            .into(holder.img)
        holder.prdName.text = userList[position].prd_name.toString()
        holder.prdPrice.text = userList[position].prd_price.toString()
        holder.itemViewLayout.setOnClickListener {
            mCallBackToFragmentListener?.callBack(
                userList[position].img.toString(),
                userList[position].prd_description.toString()
            )
        }
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    fun setCallBackListener(callBackToFragmentListener: CallBackToFragmentListener){
        this.mCallBackToFragmentListener = callBackToFragmentListener
    }






}