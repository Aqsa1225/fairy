package com.example.fairytalestories

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.fairytalestoriesbook.R

class UserInfoDialogFragment : DialogFragment() {

    interface OnInputListener {
        fun sendInput(name: String, age: String)
    }

    private var onInputListener: OnInputListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_user_info, container, false)

        val etName = view.findViewById<EditText>(R.id.etName)
        val etAge = view.findViewById<EditText>(R.id.etAge)
        val btnSave = view.findViewById<Button>(R.id.btnSave)

        // Load existing data
        val sharedPreferences = activity?.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        etName.setText(sharedPreferences?.getString("name", ""))
        etAge.setText(sharedPreferences?.getString("age", ""))

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString()

            if (name.isEmpty() || age.isEmpty()) {
                Toast.makeText(activity, "Please enter all details", Toast.LENGTH_SHORT).show()
            } else {
                onInputListener?.sendInput(name, age)
                dismiss()
            }
        }

        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setCanceledOnTouchOutside(false)
        }
    }

    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        try {
            onInputListener = context as OnInputListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnInputListener")
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}
