package com.bwjf.createpdf.result;

public class CodeMsg {
	
	private int code;
	private String msg;
	private String result;
	private String rows;


	/**
	 * 通用的错误码
	 */

	//成功
	public static CodeMsg SUCCESS = new CodeMsg(0, "success","SUCCESS","");

	//服务端异常
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "system exception","ERROR","");
	//参数校验异常
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "params checking exception","ERROR","");
	//接口请求太频繁，请稍后再试
	public static CodeMsg REQUEST_ERROR = new CodeMsg(500102, "Requests are too frequent. Please try again later!","ERROR","");



	//开具发票模块 5002XX
	public static CodeMsg XSF_PDFINFO_SUCCESS = new CodeMsg(0, "xsf pdf_information checking OK!","SUCCESS","");
	public static CodeMsg XSF_CA_SUB_INFO_SUCCESS = new CodeMsg(0, "xsf ca_sub_information checking OK!","SUCCESS","");
	public static CodeMsg XSF_CA_INFO_SUCCESS = new CodeMsg(0, "xsf ca_information checking OK!","SUCCESS","");

	//没有访问此接口的权限
	public static CodeMsg ACCESS_INTERFACE_ERROR = new CodeMsg(500201, "do not have access to this interface","ERROR","");
	public static CodeMsg SERVICEKEY_ERROR = new CodeMsg(500202, "serviceKey is null","ERROR","");
	//servicekey或nsrsbh为空
	public static CodeMsg SERVICEKEY_OR_NSRSBH_ERROR = new CodeMsg(500203, "serviceKey or nsrsbh is null","ERROR","");

	public static CodeMsg XSF_PDF_INFO_ERROR = new CodeMsg(500204, "xsf pdf information is incomplete!","ERROR","");
	public static CodeMsg XSF_CAGIF_INFO_ERROR = new CodeMsg(500205, "xsf caGif information is incomplete!","ERROR","");
	public static CodeMsg XSF_CA_INFO_ERROR = new CodeMsg(500206, "xsf ca information is incomplete!","ERROR","");




//	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
//	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
//	public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
//	public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
//	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");
	
	//商品模块 5003XX
	
	//订单模块 5004XX
	
	//秒杀模块 5005XX
	
	public CodeMsg( ) {
	}

	public CodeMsg(int code, String msg, String result, String rows) {
		this.code = code;
		this.msg = msg;
		this.result = result;
		this.rows = rows;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message,result,rows);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "CodeMsg{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", result='" + result + '\'' +
				'}';
	}
}
