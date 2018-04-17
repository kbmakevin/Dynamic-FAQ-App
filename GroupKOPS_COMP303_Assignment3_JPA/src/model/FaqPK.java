package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the faq database table.
 * 
 */
@Embeddable
public class FaqPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="topic_id", insertable=false, updatable=false)
	private int topicId;

	@Column(name="question_id")
	private int questionId;

	public FaqPK() {
	}
	public int getTopicId() {
		return this.topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getQuestionId() {
		return this.questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FaqPK)) {
			return false;
		}
		FaqPK castOther = (FaqPK)other;
		return 
			(this.topicId == castOther.topicId)
			&& (this.questionId == castOther.questionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.topicId;
		hash = hash * prime + this.questionId;
		
		return hash;
	}
}