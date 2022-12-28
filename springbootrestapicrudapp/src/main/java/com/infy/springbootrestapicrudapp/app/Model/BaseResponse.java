package com.infy.springbootrestapicrudapp.app.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

	private Integer statuscode;// 200 to 500 
	private String msg;		// information 	
	private T responseData;	// 
	

}
