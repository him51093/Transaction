package rbs.module.transaction.model;

public class LoanTransaction extends Transaction {
	private double transactionFrom;
	private double transactionTo;
	private String transactionFromType;
	private String transactionToType;
	private String transactionDescription;
	public double getTransactionFrom() {
		return transactionFrom;
	}
	public void setTransactionFrom(double transactionFrom) {
		this.transactionFrom = transactionFrom;
	}
	public double getTransactionTo() {
		return transactionTo;
	}
	public void setTransactionTo(double transactionTo) {
		this.transactionTo = transactionTo;
	}
	public String getTransactionFromType() {
		return transactionFromType;
	}
	public void setTransactionFromType(String transactionFromType) {
		this.transactionFromType = transactionFromType;
	}
	public String getTransactionToType() {
		return transactionToType;
	}
	public void setTransactionToType(String transactionToType) {
		this.transactionToType = transactionToType;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	
	
}
