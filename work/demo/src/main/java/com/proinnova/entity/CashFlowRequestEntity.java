package com.proinnova.entity;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class CashFlowRequestEntity {
	/*
	 *合同号
	 */
	private String contract_no;

	public String getContract_no(){
		return contract_no;
	}

	public void setContract_no(String contract_no){
		this.contract_no = contract_no;
	}

	/*
	 *受益期至
	 */
	private LocalDateTime cf_eff_end_date;

	public LocalDateTime getCf_eff_end_date(){
		return cf_eff_end_date;
	}

	public void setCf_eff_end_date(LocalDateTime cf_eff_end_date){
		this.cf_eff_end_date = cf_eff_end_date;
	}

	/*
	 *付款计划状态
	 */
	private Integer cf_status;

	public Integer getCf_status(){
		return cf_status;
	}

	public void setCf_status(Integer cf_status){
		this.cf_status = cf_status;
	}

	/*
	 *OA系统签报号
	 */
	private String lease_OASys_refNo;

	public String getLease_OASys_refNo(){
		return lease_OASys_refNo;
	}

	public void setLease_OASys_refNo(String lease_OASys_refNo){
		this.lease_OASys_refNo = lease_OASys_refNo;
	}

	/*
	 *受益期从
	 */
	private LocalDateTime cf_eff_start_date;

	public LocalDateTime getCf_eff_start_date(){
		return cf_eff_start_date;
	}

	public void setCf_eff_start_date(LocalDateTime cf_eff_start_date){
		this.cf_eff_start_date = cf_eff_start_date;
	}

	/*
	 *计划付款日
	 */
	private LocalDateTime cf_date;

	public LocalDateTime getCf_date(){
		return cf_date;
	}

	public void setCf_date(LocalDateTime cf_date){
		this.cf_date = cf_date;
	}

	/*
	 *计入成本的金额
	 */
	private BigDecimal cf_amount_cal;

	public BigDecimal getCf_amount_cal(){
		return cf_amount_cal;
	}

	public void setCf_amount_cal(BigDecimal cf_amount_cal){
		this.cf_amount_cal = cf_amount_cal;
	}

	/*
	 *含税金额
	 */
	private BigDecimal cf_amount;

	public BigDecimal getCf_amount(){
		return cf_amount;
	}

	public void setCf_amount(BigDecimal cf_amount){
		this.cf_amount = cf_amount;
	}

	/*
	 *发票税率
	 */
	private BigDecimal cf_vat_rate;

	public BigDecimal getCf_vat_rate(){
		return cf_vat_rate;
	}

	public void setCf_vat_rate(BigDecimal cf_vat_rate){
		this.cf_vat_rate = cf_vat_rate;
	}

	/*
	 *统一社会信用代码
	 */
	private String taxid;

	public String getTaxid(){
		return taxid;
	}

	public void setTaxid(String taxid){
		this.taxid = taxid;
	}

	/*
	 *费用项
	 */
	private String cf_usage;

	public String getCf_usage(){
		return cf_usage;
	}

	public void setCf_usage(String cf_usage){
		this.cf_usage = cf_usage;
	}

	/*
	 *收款方
	 */
	private String supplier;

	public String getSupplier(){
		return supplier;
	}

	public void setSupplier(String supplier){
		this.supplier = supplier;
	}

	/*
	 *税金
	 */
	private BigDecimal cf_amount_vat;

	public BigDecimal getCf_amount_vat(){
		return cf_amount_vat;
	}

	public void setCf_amount_vat(BigDecimal cf_amount_vat){
		this.cf_amount_vat = cf_amount_vat;
	}

	/*
	 *承租方公司
	 */
	private String company_code;

	public String getCompany_code(){
		return company_code;
	}

	public void setCompany_code(String company_code){
		this.company_code = company_code;
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
	 *发票类型
	 */
	private String cf_vat_invoice_type;

	public String getCf_vat_invoice_type(){
		return cf_vat_invoice_type;
	}

	public void setCf_vat_invoice_type(String cf_vat_invoice_type){
		this.cf_vat_invoice_type = cf_vat_invoice_type;
	}

	/*
	 *推送用户邮箱
	 */
	private String email;

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

}