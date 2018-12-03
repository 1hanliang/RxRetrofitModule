package com.lifecycle.net.callback;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifeCyc
 * @date 2018/11/30
 * @describe
 */
public class ErrorDes {
    public static final String ERROR_INFO = "无法连接到服务器,请检查您的网络";

    private static Map<String, String> errorMap = new HashMap<String, String>();

    static {
        errorMap.put(ErrorCode.ERROR_CODE_NETWORK_UNAVAILABLE, "无法连接到服务器,请检查您的网络");
        errorMap.put(ErrorCode.ERROR_CODE_SERVER_PARSE, "无法连接到服务器,请检查您的网络");

        errorMap.put(ErrorCode.ERROR_CODE_401, "无法连接到服务器,请检查您的网络");

        errorMap.put(ErrorCode.CODE_SUCCESS, "Success");
        errorMap.put(ErrorCode.ERROR_CODE_201, "没有数据");
        errorMap.put(ErrorCode.ERROR_CODE_202, "登陆失败/注册失败/修改信息失败");
        errorMap.put(ErrorCode.ERROR_CODE_203, "不可点击的轮播详情");
        errorMap.put(ErrorCode.ERROR_CODE_204, "题数不够");
        errorMap.put(ErrorCode.ERROR_CODE_205, "图片过多");
        errorMap.put(ErrorCode.ERROR_CODE_206, "图片错误");
        errorMap.put(ErrorCode.ERROR_CODE_207, "图片大于2M");
        errorMap.put(ErrorCode.ERROR_CODE_208, "访问错误的接口");

        errorMap.put(ErrorCode.ERROR_CODE_001, "缺少必填的参数");
        errorMap.put(ErrorCode.ERROR_CODE_002, "手机号已存在");
        errorMap.put(ErrorCode.ERROR_CODE_003, "请勿频繁发送验证码");
        errorMap.put(ErrorCode.ERROR_CODE_004, "短信发送失败");
        errorMap.put(ErrorCode.ERROR_CODE_005, "手机号不存在");
        errorMap.put(ErrorCode.ERROR_CODE_006, "账号或密码不一致");
        errorMap.put(ErrorCode.ERROR_CODE_007, "令牌过期,请登录");
        errorMap.put(ErrorCode.ERROR_CODE_008, "请完善考试信息");
        errorMap.put(ErrorCode.ERROR_CODE_009, "请勿重复注册");
        errorMap.put(ErrorCode.ERROR_CODE_010, "优惠券领取已满");
        errorMap.put(ErrorCode.ERROR_CODE_011, "数据传入错误");
        errorMap.put(ErrorCode.ERROR_CODE_012, "题量不够");
        errorMap.put(ErrorCode.ERROR_CODE_013, "优惠券金额不足");
    }

    public static String getErrorDesc(String code) {
        return errorMap.get(code);
    }
}
