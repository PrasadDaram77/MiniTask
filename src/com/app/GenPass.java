package com.app;

import java.util.UUID;

public class GenPass {
	//this line add by for practice
	public static String genPwd(){
		
		return UUID.randomUUID().toString().replaceAll("-","").substring(0, 8).toUpperCase();
	}
	
	
	

}
