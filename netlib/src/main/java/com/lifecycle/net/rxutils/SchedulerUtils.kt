package com.lifecycle.net.rxutils

/**
 * @author lifeCyc
 * @date 2018/11/30
 * @describe
 */
object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }
}