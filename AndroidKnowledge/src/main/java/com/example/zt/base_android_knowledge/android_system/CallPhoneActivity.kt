package com.example.zt.base_android_knowledge.android_system

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.zt.android.knowledge.R
import com.example.zt.base_android_knowledge.base.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_call_phone.*

/**
 * @author 祝涛
 * @time 2021/6/25 17:10
 * @describe 拨打电话
 */
class CallPhoneActivity : BaseMvpActivity() {

    //拨号请求码
    companion object Static {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, CallPhoneActivity::class.java)
            context.startActivity(starter)
        }

        const val REQUEST_CALL_PERMISSION = 10111
    }

    override fun layoutId(): Int {
        return R.layout.activity_call_phone
    }

    override fun initData() {}
    override fun initView() {
        checkReadPermission(android.Manifest.permission.CALL_PHONE, REQUEST_CALL_PERMISSION)
        tv_click_go_2_call_phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            val url = Uri.parse("tel:" + 10000)
            intent.data = url
            startActivity(intent)
        }
    }


    fun checkReadPermission(string_permission: String, request_code: Int): Boolean {
        var flag = false
        if (ContextCompat.checkSelfPermission(
                this,
                string_permission
            ) == PackageManager.PERMISSION_GRANTED
        ) { //已有权限
            flag = true
        } else { //申请权限
            ActivityCompat.requestPermissions(this, arrayOf(string_permission), request_code)
        }
        return flag
    }


    override fun initEvent() {}
}