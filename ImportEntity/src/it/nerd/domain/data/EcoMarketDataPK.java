package it.nerd.domain.data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ECO_MARKET_DATA database table.
 * 
 */
@Embeddable
public class EcoMarketDataPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_REF")
	private java.util.Date dtRef;

	@Temporal(TemporalType.DATE)
	@Column(name="TERM_DATE")
	private java.util.Date termDate;

	@Column(name="TYPE_INDEX")
	private String typeIndex;

	public EcoMarketDataPK() {
	}
	public java.util.Date getDtRef() {
		return this.dtRef;
	}
	public void setDtRef(java.util.Date dtRef) {
		this.dtRef = dtRef;
	}
	public java.util.Date getTermDate() {
		return this.termDate;
	}
	public void setTermDate(java.util.Date termDate) {
		this.termDate = termDate;
	}
	public String getTypeIndex() {
		return this.typeIndex;
	}
	public void setTypeIndex(String typeIndex) {
		this.typeIndex = typeIndex;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EcoMarketDataPK)) {
			return false;
		}
		EcoMarketDataPK castOther = (EcoMarketDataPK)other;
		return 
			this.dtRef.equals(castOther.dtRef)
			&& this.termDate.equals(castOther.termDate)
			&& this.typeIndex.equals(castOther.typeIndex);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dtRef.hashCode();
		hash = hash * prime + this.termDate.hashCode();
		hash = hash * prime + this.typeIndex.hashCode();
		
		return hash;
	}
}