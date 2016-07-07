package com.kfpanda.secu.action;

/**
 * http请求错误码。
 * @author kfpanda
 * @date 2016/6/7
 */
public enum ErrorEnum {

    /** base code **/
    SUCC(0,"成功"),
    ERROR(-1,"请求失败"),
    FORMAT(-2,"{}({})参数格式错误."),
    NOTNULL(-3,"({})中的参数不能为空."),

    SQLUPDATE(-100, "数据库更新结果：{}."),

    /** other code. **/
    C(-2,"短信类型码不支持"),
    D(-3,"短信通道发送失败"),
    E(-4,"参数手机号码列表为空"),
    F(-5,"未匹配短信发送策略"),
    G(-6, "redis缓存的短信通道为NULL"),
    H(-7,"传递参数个数不匹配");

    // 成员变量
    private Integer key;
    private String value;

    @Override
    public String toString() {
        return String.valueOf(this.key);
    }

    // 构造方法
    ErrorEnum(Integer key, String value){
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

}