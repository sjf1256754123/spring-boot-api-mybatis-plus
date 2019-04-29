package com.demo.core;

/**
* @ClassName: CodeMsgEnum
* @Description: TODO 请求返回信息枚举类
* @author F_xh
* @date 2017年4月28日 下午4:21:31
*
*/
public enum CodeMsgEnum {
	//参数请求信息
	ILLEGALREQUEST("0","8000","非法请求"),
	PARAMERR("0","8001","参数错误"),
	CACHEEXPIRED("0","8002","缓存失败"),

	USER_LOGIN_SUCCESS("1","","登陆成功"),
	USER_LOGIN_ERROR("0","","账号或密码错误"),
	USER_LOGIN_ERROR_ACCOUNT("0","","账号错误"),
	USER_LOGIN_ERROR_PW("0","","密码错误"),
	USER_SAVE_SUCCESS("1","","修改成功"),
	USER_MODIFY_ERROR_PW("0","","原密码错误"),
	USER_MODIFY_ERROR_CONFIRM("0","","两次输入不一致"),

	TOKEN_ERROR("1","","Token错误或失效"),
	RANDOM_CODE_ERROR("0","","验证码错误"),

	// 复制
	COPY_SUCCESS("1", "", "复制成功"),
	COPY_ERROR("0", "", "复制失败"),

	// 保存
	SAVE_SUCCESS("1", "", "保存成功"),
	SAVE_ERROR("0", "", "保存失败"),
	SAVE_REFUSE("0", "", "不可编辑"),

	// 查询
	SEARCH_SUCCESS("1", "", "查询成功"),
	SEARCH_ERROR("0", "", "查询失败"),

	// 删除
	DEL_SUCCESS("1", "", "删除成功"),
	DEL_ERROR("0", "", "删除失败"),
	DEL_REFUSE("0", "", "不可删除"),

	// 是否成功
	SUCCESS("1", "", ""),
	ERROR("0", "", ""),

	//免责声明，关于
	DISCLAIMERABOUTSUCCESS("1","8090","获取成功"),

	/*web enum---------end--*/
	//系统信息
	SYSTEM("0","10000","系统异常，请刷新后重试或联系系统管理员"),

	STATUS(),BUSINESSSTATUS(),ITEMS(),MESSAGE(),FEEDBACK();

	private String code;
	private String bunissCode;
	private String msg;

	private CodeMsgEnum(String code, String bunissCode, String msg){
		this.code=code;
		this.bunissCode=bunissCode;
		this.msg=msg;
	}

	private CodeMsgEnum(){

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBunissCode() {
		return bunissCode;
	}

	public void setBunissCode(String bunissCode) {
		this.bunissCode = bunissCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static void main(String[] args){
		System.out.print(CodeMsgEnum.DISCLAIMERABOUTSUCCESS);
	}
}
