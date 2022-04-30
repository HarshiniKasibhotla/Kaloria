package com.csci5308.kaloria.notification;

import java.util.List;

public interface IMessage {

	void setSubject(String subject);

	String getSubject();

	void setRecipients(List<String> recipients);

	List<String> getRecipients();

	void setBody(String body);

	String getBody();
}
