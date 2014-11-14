package it.nerd.domain.data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ECO_STG_PARAM database table.
 * 
 */
@Entity
@Table(name="ECO_STG_PARAM")
@NamedQuery(name="EcoStgParam.findAll", query="SELECT e FROM EcoStgParam e")
public class EcoStgParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PARAM")
	private String idParam;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_AGG")
	private Date dtAgg;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_FIN")
	private Date dtFin;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_INI")
	private Date dtIni;

	@Column(name="\"VALUE\"")
	private BigDecimal value;

	public EcoStgParam() {
	}

	public String getIdParam() {
		return this.idParam;
	}

	public void setIdParam(String idParam) {
		this.idParam = idParam;
	}

	public Date getDtAgg() {
		return this.dtAgg;
	}

	public void setDtAgg(Date dtAgg) {
		this.dtAgg = dtAgg;
	}

	public Date getDtFin() {
		return this.dtFin;
	}

	public void setDtFin(Date dtFin) {
		this.dtFin = dtFin;
	}

	public Date getDtIni() {
		return this.dtIni;
	}

	public void setDtIni(Date dtIni) {
		this.dtIni = dtIni;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}