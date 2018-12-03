package com.lifecycle.rxretrofit.api


import com.lifecycle.net.model.ResponseWrapper
import com.lifecycle.rxretrofit.moeld.LoginBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author lifeCyc
 * @date 2018/11/30
 * @describe api服务
 */
interface LoginApi {

    /**
     * 登录
     */
    @GET("banner/json")
    fun requestLogin(): Observable<ResponseWrapper<List<LoginBean.DataBean>>>

}