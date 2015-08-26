package com.sssystem.edu.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidateParamChk {

	public ValidateParamChk() {
		// TODO Auto-generated constructor stub
	}
	public boolean isNumeric(String param) {
		if (param.matches("\\d+")){
			return true;
		}
		return false;
	}
	public int toInteger(String param) {
		return Integer.parseInt(param);
	}
	public boolean isEmpty(String param){
		if (param == null || param.equals("")){
			return true;
		}
		return false;
	}
	public String getParam(String param){
		if (param != null) {
			param = param.trim();
			param = Pattern.compile("\\s").matcher(param).replaceAll("");
		}
		return param;
	}
	public boolean isDate(String param){
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(param);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public Date toDate(String param){
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date = sdf.parse(param);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
