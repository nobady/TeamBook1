package com.loufei.teambook.ui

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loufei.androidx_permission.annotation.PermissionCanceled
import com.loufei.androidx_permission.annotation.PermissionDenied
import com.loufei.androidx_permission.annotation.Permissions
import com.loufei.teambook.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @Permissions(permissions = [Manifest.permission.CAMERA])
    fun takePhoto(){
        //省略代码
    }

    @PermissionCanceled
    fun onCancel(){
        //权限取消时执行的逻辑
    }

    @PermissionDenied
    fun onDenied(){
        //权限拒绝时执行的逻辑
    }
}
