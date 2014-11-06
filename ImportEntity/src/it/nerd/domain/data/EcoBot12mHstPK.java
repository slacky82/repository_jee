package it.nerd.domain.data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ECO_BOT12M_HST database table.
 * 
 */
@Embeddable
public class EcoBot12mHstPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long anno;

	private long mese;

	public EcoBot12mHstPK() {
	}
	public long getAnno() {
		return this.anno;
	}
	public void setAnno(long anno) {
		this.anno = anno;
	}
	public long getMese() {
		return this.mese;
	}
	public void setMese(long mese) {
		this.mese = mese;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EcoBot12mHstPK)) {
			return false;
		}
		EcoBot12mHstPK castOther = (EcoBot12mHstPK)other;
		return 
			(this.anno == castOther.anno)
			&& (this.mese == castOther.mese);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.anno ^ (this.anno >>> 32)));
		hash = hash * prime + ((int) (this.mese ^ (this.mese >>> 32)));
		
		return hash;
	}
}