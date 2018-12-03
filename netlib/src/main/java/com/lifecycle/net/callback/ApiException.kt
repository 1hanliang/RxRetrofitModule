package com.lifecycle.net.callback

/**
 * @author lifeCyc
 * @date 2018/11/30
 * @describe
 */
class ApiException//    public ApiException (int errorCode, String errorMessage)
//    {
//        super(errorMessage);
//        mErrorCode = errorCode;
//    }
(var code: String, msg: String) : RuntimeException(msg) {

    //    /**
//     * 判断是否是token失效
//     *
//     * @return 失效返回true, 否则返回false;
//     */
//    public boolean isTokenExpried()
//    {
//        return mErrorCode == Constants.TOKEN_EXPRIED;
//    }
}