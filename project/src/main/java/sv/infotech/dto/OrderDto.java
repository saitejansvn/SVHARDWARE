package sv.infotech.dto;

import java.io.Serializable;

public class OrderDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String orderId;
	private int customerId;
	private String typeOfOperation;
	private String serviceFor;
	private String typeOfProblem;
	private String complaint;
	private String problemDescription;
	private int totalAmount;
	private String paymentMode;
	private int advanceAmount;
	private int balanceAmount = totalAmount - advanceAmount;
	private String onService="Y";
	private String isOrderDeliverd="N";
	public OrderDto() {
		super();
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getTypeOfOperation() {
		return typeOfOperation;
	}
	public void setTypeOfOperation(String typeOfOperation) {
		this.typeOfOperation = typeOfOperation;
	}
	public String getServiceFor() {
		return serviceFor;
	}
	public void setServiceFor(String serviceFor) {
		this.serviceFor = serviceFor;
	}
	public String getTypeOfProblem() {
		return typeOfProblem;
	}
	public void setTypeOfProblem(String typeOfProblem) {
		this.typeOfProblem = typeOfProblem;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public int getAdvanceAmount() {
		return advanceAmount;
	}
	public void setAdvanceAmount(int advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	public int getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public String getOnService() {
		return onService;
	}
	public void setOnService(String onService) {
		this.onService = onService;
	}
	public String getIsOrderDeliverd() {
		return isOrderDeliverd;
	}
	public void setIsOrderDeliverd(String isOrderDeliverd) {
		this.isOrderDeliverd = isOrderDeliverd;
	}
	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", customerId=" + customerId + ", typeOfOperation=" + typeOfOperation
				+ ", serviceFor=" + serviceFor + ", typeOfProblem=" + typeOfProblem + ", complaint=" + complaint
				+ ", problemDescription=" + problemDescription + ", totalAmount=" + totalAmount + ", paymentMode="
				+ paymentMode + ", advanceAmount=" + advanceAmount + ", balanceAmount=" + balanceAmount + ", onService="
				+ onService + ", isOrderDeliverd=" + isOrderDeliverd + "]";
	}

	// def constructor,set/get, toString
	

	
	
}
