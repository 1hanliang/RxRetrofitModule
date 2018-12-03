package com.lifecycle.net.rxutils

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author lifeCyc
 * @date 2018/11/30
 * @describe
 */
class IoMainScheduler<T> : BaseScheduler<T>(Schedulers.io(), AndroidSchedulers.mainThread())