package com.lifecycle.net.callback

import android.util.Log
import com.google.gson.JsonParseException
import com.lifecycle.net.model.ApiErrorModel
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException

/**
 * @author lifeCyc
 * @date 2018/11/30
 * @describe
 */

class ExceptionHandle {


    companion object {

        private var errorCode = ErrorStatus.UNKNOWN_ERROR
        private var errorMsg = "请求失败，请稍后重试"

        private const val UNAUTHORIZED = 401
        private const val FORBIDDEN = 403
        private const val NOT_FOUND = 404
        private const val REQUEST_TIMEOUT = 408
        private const val INTERNAL_SERVER_ERROR = 500
        private const val BAD_GATEWAY = 502
        private const val SERVICE_UNAVAILABLE = 503
        private const val GATEWAY_TIMEOUT = 504

        fun handleException(e: Throwable): ApiErrorModel {
            e.printStackTrace()
            if (e is HttpException) {
                errorCode = e.code()
                errorMsg = when (e.code()) {
                    UNAUTHORIZED,
                    FORBIDDEN,
                    NOT_FOUND,
                    REQUEST_TIMEOUT,
                    GATEWAY_TIMEOUT,
                    INTERNAL_SERVER_ERROR,
                    BAD_GATEWAY,
                    SERVICE_UNAVAILABLE -> "网络错误"
                    else -> "网络错误"
                }
            } else if (e is SocketTimeoutException) {//网络超时
                Log.e("TAG", "网络连接异常: " + e.message)
                errorMsg = "网络连接异常"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if (e is ConnectException) { //均视为网络错误
                Log.e("TAG", "网络连接异常: " + e.message)
                errorMsg = "网络连接异常"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if (e is JsonParseException
                    || e is JSONException
                    || e is ParseException) {   //均视为解析错误
                Log.e("TAG", "数据解析异常: " + e.message)
                errorMsg = "数据解析异常"
                errorCode = ErrorStatus.SERVER_ERROR
            } else if (e is UnknownHostException) {
                Log.e("TAG", "网络连接异常: " + e.message)
                errorMsg = "网络连接异常"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if (e is IllegalArgumentException) {
                errorMsg = "参数错误"
                errorCode = ErrorStatus.SERVER_ERROR
            } else if (e is ApiException) {
                errorMsg = ErrorDes.getErrorDesc(e.code)
                errorCode = e.code.toInt()
            } else {//未知错误
                try {
                    Log.e("TAG", "错误: " + e.message)
                } catch (e1: Exception) {
                    Log.e("TAG", "未知错误Debug调试 ")
                }

                errorMsg = "未知错误，可能抛锚了吧~"
                errorCode = ErrorStatus.UNKNOWN_ERROR
            }
            return ApiErrorModel(errorCode, errorMsg)
        }

    }


    object ErrorStatus {

//        /**
//         * 响应成功
//         *  @JvmField 注解可以阻止该变量自动生成getset方法
//         */
//        @JvmField
//        val SUCCESS = 0

        /**
         * 未知错误
         */
        @JvmField
        val UNKNOWN_ERROR = 1002

        /**
         * 服务器内部错误
         */
        @JvmField
        val SERVER_ERROR = 1003

        /**
         * 网络连接超时
         */
        @JvmField
        val NETWORK_ERROR = 1004

//        /**
//         * API解析异常（或者第三方数据结构更改）等其他异常
//         */
//        @JvmField
//        val API_ERROR = 1005

    }


}