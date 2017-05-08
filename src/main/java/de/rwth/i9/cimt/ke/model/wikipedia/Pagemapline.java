package de.rwth.i9.cimt.ke.model.wikipedia;
// Generated May 7, 2017 1:46:11 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pagemapline generated by hbm2java
 */
@Entity
@Table(name = "pagemapline", catalog = "simplewikidb")
public class Pagemapline implements java.io.Serializable {

	private Long id;
	private String name;
	private Integer pageId;
	private String stem;
	private String lemma;

	public Pagemapline() {
	}

	public Pagemapline(String name, Integer pageId, String stem, String lemma) {
		this.name = name;
		this.pageId = pageId;
		this.stem = stem;
		this.lemma = lemma;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pageID")
	public Integer getPageId() {
		return this.pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	@Column(name = "stem")
	public String getStem() {
		return this.stem;
	}

	public void setStem(String stem) {
		this.stem = stem;
	}

	@Column(name = "lemma")
	public String getLemma() {
		return this.lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

}
