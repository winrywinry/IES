package com.sssystem.edu.common;

public class ConvertStr {
   public static String toJS(String str){
	  return str.replace("\\", "\\\\")
			  .replace("\'", "\\\'" )   //  '  ----->   \'
			 .replace("\"", "\\\"")
			 .replace("\r\n", "\\n")
			 .replace("\n", "\\n");			 
   }
}
