package com.example.modified



import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentTransaction

class Fragment1 : Fragment() , Communicator {
    private val keyname = "inputEditText"
    private lateinit var sharedPref: SharedPreferences
    private lateinit var comm: Communicator
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = layoutInflater.inflate(R.layout.fragment_a, container, false)
        comm = this

        val enterBtn = rootView.findViewById<Button>(R.id.enter_btn)
        val password = rootView.findViewById<EditText>(R.id.et_pass)
        password.transformationMethod = PasswordTransformationMethod.getInstance()
        val inputEditText : EditText = rootView.findViewById(R.id.input_edit_text)
        sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)!!


        val value : String? = sharedPref.getString(keyname, "")
        inputEditText.setText(value)

        enterBtn.setOnClickListener{
            val editor = sharedPref.edit()
            editor.putString(keyname, inputEditText.text.toString())
            editor.apply()
            comm.passDataCom(inputEditText.text.toString())

        }
        return rootView
    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("input_txt", editTextInput)

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val frag2 = Fragment2()
        frag2.arguments = bundle

        transaction?.replace(R.id.content_id, frag2)
        transaction?.addToBackStack(null)
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction?.commit()


    }
}