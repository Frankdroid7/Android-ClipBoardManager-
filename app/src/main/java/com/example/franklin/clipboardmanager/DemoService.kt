package com.example.franklin.clipboardmanager

import android.app.Service
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class DemoService : Service() {


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        onTaskRemoved(intent)


        var myClipManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager


        val myClipData = ClipData.newPlainText("text", myClipManager.primaryClip.toString())
        myClipManager.primaryClip = myClipData

        Toast.makeText(this, "COPIED", Toast.LENGTH_LONG).show()


        var getP = myClipManager.primaryClip
        var item = getP.getItemAt(0).toString()
        if (item.contains("J")) {
            var clipd = ClipData.newPlainText("text", "noooo")
            myClipManager.primaryClip = clipd

        } else {
            item = "I DON'T KNOW"


        }

        Toast.makeText(this, "PASTED", Toast.LENGTH_LONG).show()
        return START_STICKY
//
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override fun onTaskRemoved(rootIntent: Intent?) {
//
//        var i = Intent(applicationContext,DemoService::class.java)
//        i.setPackage(packageName)
//        startService(i)
//        super.onTaskRemoved(rootIntent)
//    }

}



