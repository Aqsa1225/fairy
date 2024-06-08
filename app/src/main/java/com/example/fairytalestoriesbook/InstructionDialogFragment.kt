package com.example.fairytalestoriesbook

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class InstructionDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = LayoutInflater.from(requireActivity())
        val view = inflater.inflate(R.layout.dialog_instruction, null)
        builder.setView(view)

        val btnGotIt = view.findViewById<Button>(R.id.btnGotIt)
        btnGotIt.setOnClickListener {
            // Dismiss the dialog when the button is clicked
            dismiss()
        }

        return builder.create()
    }
}


