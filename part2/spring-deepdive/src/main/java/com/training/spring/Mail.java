package com.training.spring;

public class Mail {
	private String toAddress;
	private String fromAddress;
	private Message message;
	
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Mail [toAddress=" + toAddress + ", fromAddress=" + fromAddress + ", message=" + message.toString() + "]";
	}
	
	
	
}
