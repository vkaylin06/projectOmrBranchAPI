package com.pojo;

/**
 * 
 * @author Mary Claena Aylin
 * @Date 05-Aug-2022
 * @Description maintains all DeleteAddress_Input_pojo information
 *
 */
public class DeleteAddress_Input_pojo {

	private String address_id;

	/**
	 * @Description create constructor for the field
	 * @param address_id
	 */
	public DeleteAddress_Input_pojo(String address_id) {
		super();
		this.address_id = address_id;
	}

	public String getAddress_id() {
		return address_id;
	}

}
