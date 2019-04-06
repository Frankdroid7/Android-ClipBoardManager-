package com.example.franklin.clipboardmanager

import android.content.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var snackBar: Snackbar

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        copy_button.setOnClickListener {
            val editText1Text = editText1.text.toString()

            val mClip = ClipData.newPlainText("text", editText1Text)
            clipboardManager.primaryClip = mClip!!

            snackBar = Snackbar.make(constraint_root_tag, "Text Copied", Snackbar.LENGTH_LONG)
                    .setAction("Dismiss") { snackBar.dismiss() }
            snackBar.show()

        }

        paste_button.setOnClickListener {
            val editText2 = findViewById<EditText>(R.id.editText2)

            val clipBoardText = clipboardManager.primaryClip!!.getItemAt(0).text
            editText2.setText(clipBoardText)

            snackBar = Snackbar.make(constraint_root_tag, "Text Pasted", Snackbar.LENGTH_LONG)
                    .setAction("Dismiss") { snackBar.dismiss() }
            snackBar.show()

        }

        change_text_button.setOnClickListener {

            val changeText = findViewById<EditText>(R.id.change_text_editText)
            clipboardManager.primaryClip = ClipData.newPlainText("text", changeText.text.toString())

            snackBar = Snackbar.make(constraint_root_tag, "Copied text changed to '${changeText.text}'",
                    Snackbar.LENGTH_LONG)
                    .setAction("Dismiss") { snackBar.dismiss() }
            snackBar.show()

        }

        check_description_button.setOnClickListener {

            val clipboardTextDesc = clipboardManager.primaryClip?.description?.label.toString()
            snackBar = Snackbar.make(constraint_root_tag, "Copied Text Description is '$clipboardTextDesc'",
                    Snackbar.LENGTH_LONG)
                    .setAction("Dismiss"){ snackBar.dismiss() }
            snackBar.show()

        }

    }

}



