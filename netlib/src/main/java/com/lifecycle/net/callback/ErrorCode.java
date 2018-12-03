package com.lifecycle.net.callback;

/**
 * @author lifeCyc
 * @date 2018/11/30
 * @describe
 */
public class ErrorCode {
    public static final String CODE_SUCCESS = "200";//成功

    public static final String ERROR_CODE_NETWORK_UNAVAILABLE = "-1";

    public static final String ERROR_CODE_SERVER_PARSE = "400";//服务器不理解请求的语法。
    public static final String ERROR_CODE_401 = "401";//未知错误


    public static final String ERROR_CODE_201 = "201";//请求成功没有数据
    public static final String ERROR_CODE_202 = "202";//登陆失败/注册失败/修改信息失败
    public static final String ERROR_CODE_203 = "203";//不可点击的轮播详情
    public static final String ERROR_CODE_204 = "204";//题数不够
    public static final String ERROR_CODE_205 = "205";//图片过多
    public static final String ERROR_CODE_206 = "206";//图片不合法
    public static final String ERROR_CODE_207 = "207";//图片大于2M
    public static final String ERROR_CODE_208 = "208";//访问错误的接口

    public static final String ERROR_CODE_001 = "001";//缺少必填的参数
    public static final String ERROR_CODE_002 = "002";//手机号已存在
    public static final String ERROR_CODE_003 = "003";//请勿频繁发送验证码
    public static final String ERROR_CODE_004 = "004";//短信发送失败
    public static final String ERROR_CODE_005 = "005";//手机号不存在
    public static final String ERROR_CODE_006 = "006";//账号或密码不一致
    public static final String ERROR_CODE_007 = "007";//请登录
    public static final String ERROR_CODE_008 = "008";//请完善考试信息
    public static final String ERROR_CODE_009 = "009";//请勿重复注册
    public static final String ERROR_CODE_010 = "010";//优惠券领取已满
    public static final String ERROR_CODE_011 = "011";//数据传入错误
    public static final String ERROR_CODE_012 = "012";//题量不够
    public static final String ERROR_CODE_013 = "013";//优惠券金额不足
}