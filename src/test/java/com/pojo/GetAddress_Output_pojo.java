package com.pojo;

import java.util.ArrayList;
/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all GetAddress_Output_pojo information
 *
 */
public class GetAddress_Output_pojo {
	public int status;
    public String message;
    public ArrayList<Datum> data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Datum> getData() {
		return data;
	}
	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}

}
