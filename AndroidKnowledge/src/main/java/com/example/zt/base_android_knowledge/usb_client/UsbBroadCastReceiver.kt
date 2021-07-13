package com.example.zt.base_android_knowledge.usb_client

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.util.Log
import android.widget.Toast

class UsbBroadCastReceiver : BroadcastReceiver() {
    companion object StaticParams {
        const val ACTION = "android.hardware.usb.action.USB_STATE"
        const val ACTION_USB_PERMISSION = "com.android.example.USB_PERMISSION"
        const val TAG = "UsbBroadCastReceiver"
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (ACTION_USB_PERMISSION == intent.action) {
            synchronized(this) {
                val device: UsbDevice? = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE)
                Log.d(TAG, "onReceive ACTION_USB_PERMISSION : ${device?.deviceName}")
                Toast.makeText(
                    context,
                    device?.deviceName,
                    Toast.LENGTH_SHORT
                ).show()
                if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                    device?.apply {
                        //call method to set up device communication
                    }
                } else {
                    Log.d(TAG, "permission denied for device $device")
                }

            }
        }
        if (intent.action == ACTION) {
            val device: UsbDevice? = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE)
            Log.d(TAG, "onReceive ACTION: ${device?.deviceName}")
            val usbIsConnected = intent.extras?.getBoolean("connected")
            Toast.makeText(
                context,
                if (usbIsConnected == true) "连接上了" else "断开了",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}