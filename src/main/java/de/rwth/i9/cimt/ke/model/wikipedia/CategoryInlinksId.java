package de.rwth.i9.cimt.ke.model.wikipedia;
// Generated May 7, 2017 1:46:11 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CategoryInlinksId generated by hbm2java
 */
@Embeddable
public class CategoryInlinksId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9204630833403697862L;
	private long id;
	private Integer inLinks;

	public CategoryInlinksId() {
	}

	public CategoryInlinksId(long id) {
		this.id = id;
	}

	public CategoryInlinksId(long id, Integer inLinks) {
		this.id = id;
		this.inLinks = inLinks;
	}

	@Column(name = "id", nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "inLinks")
	public Integer getInLinks() {
		return this.inLinks;
	}

	public void setInLinks(Integer inLinks) {
		this.inLinks = inLinks;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CategoryInlinksId))
			return false;
		CategoryInlinksId castOther = (CategoryInlinksId) other;

		return (this.getId() == castOther.getId())
				&& ((this.getInLinks() == castOther.getInLinks()) || (this.getInLinks() != null
						&& castOther.getInLinks() != null && this.getInLinks().equals(castOther.getInLinks())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getId();
		result = 37 * result + (getInLinks() == null ? 0 : this.getInLinks().hashCode());
		return result;
	}

}
