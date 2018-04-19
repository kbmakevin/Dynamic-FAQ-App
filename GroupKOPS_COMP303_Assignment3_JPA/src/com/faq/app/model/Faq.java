package com.faq.app.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the faq database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Faq.findAll", query = "SELECT f FROM Faq f"),
		@NamedQuery(name = "Faq.findByContainingTopicName", query = "SELECT f FROM Faq f WHERE LOWER(f.topic.topicName) LIKE LOWER(CONCAT('%', :topicName, '%'))") })
public class Faq implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FaqPK id;

	private String answer;

	private String question;

	// bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name = "topic_id", insertable = false, updatable = false)
	private Topic topic;

	public Faq() {
	}

	public FaqPK getId() {
		return this.id;
	}

	public void setId(FaqPK id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}