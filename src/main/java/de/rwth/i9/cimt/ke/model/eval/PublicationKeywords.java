package de.rwth.i9.cimt.ke.model.eval;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * PublicationKeywords generated by hbm2java
 */
@Entity
@Table(name = "publication_keywords", catalog = "enwikidb", uniqueConstraints = @UniqueConstraint(columnNames = {
		"publication_id", "ke_algorithm", "is_wikipedia_based" }))
public class PublicationKeywords implements java.io.Serializable {

	private Integer id;
	private Boolean isWikipediaBased;
	private String keAlgorithm;
	private String keywordTokens;
	private Integer publicationId;

	public PublicationKeywords() {
	}

	public PublicationKeywords(Boolean isDefault, String keAlgorithm, String keywordTokens, Integer publicationId) {
		this.isWikipediaBased = isDefault;
		this.keAlgorithm = keAlgorithm;
		this.keywordTokens = keywordTokens;
		this.publicationId = publicationId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "is_wikipedia_based")
	public Boolean getIsWikipediaBased() {
		return this.isWikipediaBased;
	}

	public void setIsWikipediaBased(Boolean isDefault) {
		this.isWikipediaBased = isDefault;
	}

	@Column(name = "ke_algorithm", length = 50)
	public String getKeAlgorithm() {
		return this.keAlgorithm;
	}

	public void setKeAlgorithm(String keAlgorithm) {
		this.keAlgorithm = keAlgorithm;
	}

	@Column(name = "keyword_tokens")
	public String getKeywordTokens() {
		return this.keywordTokens;
	}

	public void setKeywordTokens(String keywordTokens) {
		this.keywordTokens = keywordTokens;
	}

	@Column(name = "publication_id")
	public Integer getPublicationId() {
		return this.publicationId;
	}

	public void setPublicationId(Integer publicationId) {
		this.publicationId = publicationId;
	}

}