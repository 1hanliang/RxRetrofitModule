package com.lifecycle.net

import android.util.Log
import com.lifecycle.net.gson.CustomGsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

/**
 * @author lifeCyc
 * @date 2018/11/30
 * @describe
 */
class RetrofitManager private constructor() {

    //单利
    companion object {
        var baseUrl: String = ""
        fun initUrl(baseUrl: String) {
            this.baseUrl = baseUrl
        }

        val instance: RetrofitManager by lazy { RetrofitManager() }
    }


    //    private val interceptor: Interceptor
    private val retrofit: Retrofit

    //初始化
    init {
//        //通用拦截
//        interceptor = Interceptor {
//            chain -> val request = chain.request()
//                .newBuilder()
//                .addHeader("Content_Type","application/json")
//                .addHeader("charset","UTF-8")
//                .addHeader("token",AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN))
//                .build()
//
//            chain.proceed(request)
//        }

        //Retrofit实例化
        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(CustomGsonConverterFactory.create())//GsonConverterFactory
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build()
    }

    /*
        OKHttp创建
     */
    private fun initClient(): OkHttpClient {
//        //设置请求的缓存位置和大小
//        val cacheFile = File(MyApplication.context.cacheDir, "cache")
//        val cache = Cache(cacheFile, 1024 * 1024 * 50)

        return OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
//                .addInterceptor(interceptor)
//                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    /*
        日志拦截器
     */
    private fun initLogInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String?) {
                Log.e("as", message)
            }

        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /*
        具体服务实例化
     */
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

}