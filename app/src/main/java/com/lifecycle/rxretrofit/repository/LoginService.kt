package com.lifecycle.rxretrofit.repository

import com.lifecycle.net.model.ResponseWrapper
import com.lifecycle.rxretrofit.moeld.LoginBean

import io.reactivex.Observable

interface LoginService {
    fun getList(): Observable<ResponseWrapper<List<LoginBean.DataBean>>>
}