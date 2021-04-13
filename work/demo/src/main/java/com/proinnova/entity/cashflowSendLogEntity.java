package com.proinnova.entity;

import java.time.LocalDateTime;

public class cashflowSendLogEntity {
	/*
	 *成功/失败
	 */
	private String return_type;

	public String getReturn_type(){
		return return_type;
	}

	public void setReturn_type(String return_type){
		this.return_type = return_type;
	}

	/*
	 *报文体
	 */
	private Object send_data;

	public Object getSend_data(){
		return send_data;
	}

	public void setSend_data(Object send_data){
		this.send_data = send_data;
	}

	/*
	 *付款计划推送后状态
	 */
	private Integer cf_status;

	public Integer getCf_status(){
		return cf_status;
	}

	public void setCf_status(Integer cf_status){
		this.cf_status = cf_status;
	}

	/*
	 *创建时间
	 */
	private LocalDateTime create_time;

	public LocalDateTime getCreate_time(){
		return create_time;
	}

	public void setCreate_time(LocalDateTime create_time){
		this.create_time = create_time;
	}

	/*
	 *操作人
	 */
	private String user_info;

	public String getUser_info(){
		return user_info;
	}

	public void setUser_info(String user_info){
		this.user_info = user_info;
	}

	/*
	 *付款计划推送前状态
	 */
	private Integer cf_status_old;

	public Integer getCf_status_old(){
		return cf_status_old;
	}

	public void setCf_status_old(Integer cf_status_old){
		this.cf_status_old = cf_status_old;
	}

	/*
	 *描述
	 */
	private String return_msg;

	public String getReturn_msg(){
		return return_msg;
	}

	public void setReturn_msg(String return_msg){
		this.return_msg = return_msg;
	}

	/*
	 *付款计划号
	 */
	private String id;

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	/*
	 *响应状态
	 */
	private String return_code;

	public String getReturn_code(){
		return return_code;
	}

	public void setReturn_code(String return_code){
		this.return_code = return_code;
	}

}