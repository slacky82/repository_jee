package it.nerd.domain.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ECO_ANAG_CURVE database table.
 * 
 */
@Entity
@Table(name="ECO_ANAG_CURVE")
@NamedQuery(name="EcoAnagCurve.findAll", query="SELECT e FROM EcoAnagCurve e")
public class EcoAnagCurve implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TYPE_INDEX")
	private String typeIndex;

	private String descr;

	private String note;

	public EcoAnagCurve() {
	}

	public String getTypeIndex() {
		return this.typeIndex;
	}

	public void setTypeIndex(String typeIndex) {
		this.typeIndex = typeIndex;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}