package com.lifecycle.rxretrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.lifecycle.net.RetrofitManager
import com.lifecycle.net.callback.RequestCallback
import com.lifecycle.rxretrofit.api.MyConstant
import com.lifecycle.rxretrofit.moeld.LoginBean
import com.lifecycle.rxretrofit.repository.impl.LoginServiceImpl
import io.reactivex.disposables.Disposable

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitManager.initUrl(MyConstant.BASE_URL)
        LoginServiceImpl().getList().subscribe(object : RequestCallback<List<LoginBean.DataBean>>() {
            override fun success(data: List<LoginBean.DataBean>) {
                tvText.text = data[0].desc
                Log.e("tag", data[0].desc)

            }

            override fun failure(statusCode: Int, msg: String) {
                Log.e("tag", msg)
            }

            override fun subscribe(d: Disposable) {
            }
        })
    }
}

