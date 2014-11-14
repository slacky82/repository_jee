package it.nerd.domain.data;

import java.io.Serializable;

@Embeddable
public class VwEcoEngineXfPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="MESE_EMISSIONE")
	private Integer meseEmissione;
	
	@Column(name="MESE_RIMBORSO")
	private Integer meseRimborso;
	
	@Column(name="ANNO_EMISSIONE")
	private Integer annoEmissione;
	
	@Column(name="ANNO_RIMBORSO")
	private Integer annoRimborso;	
	
	@Column(name="COD_SERIE")
	private String codSerie;

	public Integer getMeseEmissione() {
		return meseEmissione;
	}

	public void setMeseEmissione(Integer meseEmissione) {
		this.meseEmissione = meseEmissione;
	}

	public Integer getMeseRimborso() {
		return meseRimborso;
	}

	public void setMeseRimborso(Integer meseRimborso) {
		this.meseRimborso = meseRimborso;
	}

	public Integer getAnnoEmissione() {
		return annoEmissione;
	}

	public void setAnnoEmissione(Integer annoEmissione) {
		this.annoEmissione = annoEmissione;
	}

	public Integer getAnnoRimborso() {
		return annoRimborso;
	}

	public void setAnnoRimborso(Integer annoRimborso) {
		this.annoRimborso = annoRimborso;
	}

	public String getCodSerie() {
		return codSerie;
	}

	public void setCodSerie(String codSerie) {
		this.codSerie = codSerie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annoEmissione == null) ? 0 : annoEmissione.hashCode());
		result = prime * result
				+ ((annoRimborso == null) ? 0 : annoRimborso.hashCode());
		result = prime * result
				+ ((codSerie == null) ? 0 : codSerie.hashCode());
		result = prime * result
				+ ((meseEmissione == null) ? 0 : meseEmissione.hashCode());
		result = prime * result
				+ ((meseRimborso == null) ? 0 : meseRimborso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VwEcoEngineXfPK other = (VwEcoEngineXfPK) obj;
		if (annoEmissione == null) {
			if (other.annoEmissione != null)
				return false;
		} else if (!annoEmissione.equals(other.annoEmissione))
			return false;
		if (annoRimborso == null) {
			if (other.annoRimborso != null)
				return false;
		} else if (!annoRimborso.equals(other.annoRimborso))
			return false;
		if (codSerie == null) {
			if (other.codSerie != null)
				return false;
		} else if (!codSerie.equals(other.codSerie))
			return false;
		if (meseEmissione == null) {
			if (other.meseEmissione != null)
				return false;
		} else if (!meseEmissione.equals(other.meseEmissione))
			return false;
		if (meseRimborso == null) {
			if (other.meseRimborso != null)
				return false;
		} else if (!meseRimborso.equals(other.meseRimborso))
			return false;
		return true;
	}
	
	
	
	

}
