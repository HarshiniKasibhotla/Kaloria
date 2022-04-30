package com.csci5308.kaloria.notification;

import java.util.List;

public class Email implements IMessage {

	private String body;

	private List<String> recipients;

	private String subject;

	public Email(String body, List<String> recipients, String subject) {
		this.body = body;
		this.recipients = recipients;
		this.subject = subject;
	}

	public Email() {

	}

	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String getSubject() {
		return this.subject;
	}

	@Override
	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}

	@Override
	public List<String> getRecipients() {
		return this.recipients;
	}

	@Override
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String getBody() {
		return this.body;
	}
}
