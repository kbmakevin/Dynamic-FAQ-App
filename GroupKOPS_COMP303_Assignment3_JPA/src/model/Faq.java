package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the faq database table.
 * 
 */
@Entity
@NamedQuery(name="Faq.findAll", query="SELECT f FROM Faq f")
public class Faq implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FaqPK id;

	private String answer;

	private String question;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="topic_id")
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