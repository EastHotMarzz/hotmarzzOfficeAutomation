package com.hotmarzz.oa.dto;

public class FinanceDto {

	private int finId;
	private Double sumIncome;
	private Double sumExpenditure;
	private Double curCount;
	private Double preCount;
	private Double sumCount;
	public int getFinId() {
		return finId;
	}
	public void setFinId(int finId) {
		this.finId = finId;
	}
	public Double getSumIncome() {
		return sumIncome;
	}
	public void setSumIncome(Double sumIncome) {
		this.sumIncome = sumIncome;
	}
	public Double getSumExpenditure() {
		return sumExpenditure;
	}
	public void setSumExpenditure(Double sumExpenditure) {
		this.sumExpenditure = sumExpenditure;
	}
	public Double getCurCount() {
		return curCount;
	}
	public void setCurCount(Double curCount) {
		this.curCount = curCount;
	}
	public Double getPreCount() {
		return preCount;
	}
	public void setPreCount(Double preCount) {
		this.preCount = preCount;
	}
	public Double getSumCount() {
		return sumCount;
	}
	public void setSumCount(Double sumCount) {
		this.sumCount = sumCount;
	}
	@Override
	public String toString() {
		return "FinanceDto [finId=" + finId + ", sumIncome=" + sumIncome
				+ ", sumExpenditure=" + sumExpenditure + ", curCount="
				+ curCount + ", preCount=" + preCount + ", sumCount="
				+ sumCount + "]";
	}
	
}
