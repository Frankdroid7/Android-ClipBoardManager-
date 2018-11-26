package com.example.franklin.clipboardmanager

import android.content.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.ClipboardManager.OnPrimaryClipChangedListener
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

  startService(Intent(this,DemoService::class.java))


    }
}




