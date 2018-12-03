package com.lifecycle.net.model

/**
 * @author lifeCyc
 * @date 2018/11/30
 * @describe 通用的返回模型
 */
data class ResponseWrapper<T>(var data: T, var errorCode: Int, var errorMsg: String)