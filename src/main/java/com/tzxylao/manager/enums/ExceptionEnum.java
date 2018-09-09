package com.tzxylao.manager.enums;

public enum ExceptionEnum {

	ERROR_NOFOUND("9000","无法找到相应的数据"), ERROR_REQUESTMISS("9001","请求参数异常"),
	ERROR_UNKNOW("8888","未知异常");

    private String code;
	private String value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	ExceptionEnum(String code, String value){
		this.code = code;
		this.value = value;
	}

	@Override
	public String toString() {
		return "ExceptionEnum{" +
				"code='" + code + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}