package com.example.zt.base_android_knowledge.usb_client

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbInterface
import android.hardware.usb.UsbManager
import android.util.Log
import com.example.zt.android.knowledge.R
import com.example.zt.base_android_knowledge.base.BaseMvpActivity

/**
 * @author 祝涛
 * @time 2021/6/24 15:09
 * @describe usb客户端测试类
 */
class UsbTestClientActivity : BaseMvpActivity() {

    // 初始化广播
    private val usbBroadCastReceiver = UsbBroadCastReceiver()

    // USB设备对象
    lateinit var device: UsbDevice

    companion object StateParam {
        fun start(context: Context) {
            context.startActivity(Intent(context, UsbTestClientActivity::class.java))
        }

    }

    override fun layoutId(): Int {
        return R.layout.activity_usb_test_client
    }

    override fun initData() {}
    override fun initView() {
    }

    override fun initEvent() {
        // Usb设备的设备信息广播
        val managerAction = getSystemService(Context.USB_SERVICE) as UsbManager
        managerAction.deviceList.forEach {
            Log.d(TAG, "it.key : + ${it.key}")
        }
        val filterAction = IntentFilter(UsbBroadCastReceiver.ACTION)
        registerReceiver(usbBroadCastReceiver, filterAction)


        // Usb权限申请广播
        val managerActionUsbPermission = getSystemService(Context.USB_SERVICE) as UsbManager
        val permissionIntent = PendingIntent.getBroadcast(
            this,
            0,
            Intent(UsbBroadCastReceiver.ACTION_USB_PERMISSION),
            0
        )
        val filterActionUsbPermission = IntentFilter(UsbBroadCastReceiver.ACTION_USB_PERMISSION)
        registerReceiver(usbReceiver, filterActionUsbPermission)

        // 通过UsbManager去申请Usb权限
        managerActionUsbPermission.requestPermission(device, permissionIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(usbBroadCastReceiver)
    }

    private val usbReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (UsbBroadCastReceiver.ACTION_USB_PERMISSION == intent.action) {
                synchronized(this) {
                    val device: UsbDevice? = intent.getParcelableExtra(UsbManager.EXTRA_DEVICE)

                    if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                        device?.apply {
                            //call method to set up device communication
                        }
                    } else {
                        Log.d(TAG, "permission denied for device $device")
                    }
                }
            }
        }
    }
}