package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the topics database table.
 * 
 */
@Entity
@Table(name="topics")
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="topic_id")
	private int topicId;

	@Column(name="topic_name")
	private String topicName;

	//bi-directional many-to-one association to Faq
	@OneToMany(mappedBy="topic")
	private List<Faq> faqs;

	public Topic() {
	}

	public int getTopicId() {
		return this.topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Faq> getFaqs() {
		return this.faqs;
	}

	public void setFaqs(List<Faq> faqs) {
		this.faqs = faqs;
	}

	public Faq addFaq(Faq faq) {
		getFaqs().add(faq);
		faq.setTopic(this);

		return faq;
	}

	public Faq removeFaq(Faq faq) {
		getFaqs().remove(faq);
		faq.setTopic(null);

		return faq;
	}

}