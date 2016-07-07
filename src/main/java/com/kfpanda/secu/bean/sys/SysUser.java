package com.kfpanda.secu.bean.sys;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class SysUser {
    private Long id;
    private Timestamp createTime;			//创建时间
    private Timestamp updateTime;			//更新时间
    private String userName;			//登录名
    private String password;			//密码
    private String nkName;			//昵称
    private Integer status;				//是否有效, 0为未激活、1为激活、2为冻结
    private Integer type;				//类别,0是普通用户
    private String name;				//姓名
    private String email;				//邮箱账号
    private String telNo;				//手机号码
    private String idCard;				//身份证号
    private Integer sex;				//性别 0为女人，1为男人
    private String birth;					//生日
    private Integer integral;			//积分
    private String address;				//地址
    private String weiChat;				//微信号
    private Long qq;					//QQ号
    private String face;				//头像
    private String remark;				//备注
    private Long openId;				//外键，关联ter_user的id
    
    private List<SysRole> roles;				//用户拥有的角色集合
	private List<SysResource> resources;		//用户资源集合
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNkName() {
		return nkName;
	}

	public void setNkName(String nkName) {
		this.nkName = nkName;
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelNo() {
		return telNo;
	}
	
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	public String getIdCard() {
		return idCard;
	}
	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public Integer getIntegral() {
		return integral;
	}
	
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getWeiChat() {
		return weiChat;
	}
	
	public void setWeiChat(String weiChat) {
		this.weiChat = weiChat;
	}
	
	public Long getQq() {
		return qq;
	}
	
	public void setQq(Long qq) {
		this.qq = qq;
	}
	
	public String getFace() {
		return face;
	}
	
	public void setFace(String face) {
		this.face = face;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Long getOpenId() {
		return openId;
	}
	
	public void setOpenId(Long openId) {
		this.openId = openId;
	}
	
	public List<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	public List<SysResource> getResources() {
		return resources;
	}
	public void setResources(List<SysResource> resources) {
		this.resources = resources;
	}
	
	
}