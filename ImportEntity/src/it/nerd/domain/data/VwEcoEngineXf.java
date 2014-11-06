package it.nerd.domain.data;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the VW_ECO_ENGINE_XF database table.
 * 
 */
@Entity
@Table(name="VW_ECO_ENGINE_XF")
@NamedQuery(name="VwEcoEngineXf.findAll", query="SELECT v FROM VwEcoEngineXf v")
public class VwEcoEngineXf implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double alfatot;
	
	@EmbeddedId
	private VwEcoEngineXfPK id;

	@Column(name="COD_SCTG")
	private String codSctg;	

	@Temporal(TemporalType.DATE)
	@Column(name="DT_AGG")
	private Date dtAgg;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_EMESSO_AL")
	private Date dtEmessoAl;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_EMESSO_DAL")
	private Date dtEmessoDal;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_RIMBORSO_A")
	private Date dtRimborsoA;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_RIMBORSO_DA")
	private Date dtRimborsoDa;

	private Double durata;

	@Column(name="I_EMESSO")
	private Double iEmesso;

	public VwEcoEngineXfPK getId() {
		return id;
	}

	public void setId(VwEcoEngineXfPK id) {
		this.id = id;
	}

	public Double getiEmesso() {
		return iEmesso;
	}

	public void setiEmesso(Double iEmesso) {
		this.iEmesso = iEmesso;
	}

	@Column(name="PCT_BOT")
	private Double pctBot;

	@Column(name="PCT_CEDOLA")
	private Double pctCedola;

	public VwEcoEngineXf() {
	}

	public Double getAlfatot() {
		return this.alfatot;
	}

	public void setAlfatot(Double alfatot) {
		this.alfatot = alfatot;
	}

	public Integer getAnnoEmissione() {
		return this.annoEmissione;
	}

	public void setAnnoEmissione(Integer annoEmissione) {
		this.annoEmissione = annoEmissione;
	}

	public Integer getAnnoRimborso() {
		return this.annoRimborso;
	}

	public void setAnnoRimborso(Integer annoRimborso) {
		this.annoRimborso = annoRimborso;
	}

	public String getCodSctg() {
		return this.codSctg;
	}

	public void setCodSctg(String codSctg) {
		this.codSctg = codSctg;
	}

	public String getCodSerie() {
		return this.codSerie;
	}

	public void setCodSerie(String codSerie) {
		this.codSerie = codSerie;
	}

	public Date getDtAgg() {
		return this.dtAgg;
	}

	public void setDtAgg(Date dtAgg) {
		this.dtAgg = dtAgg;
	}

	public Date getDtEmessoAl() {
		return this.dtEmessoAl;
	}

	public void setDtEmessoAl(Date dtEmessoAl) {
		this.dtEmessoAl = dtEmessoAl;
	}

	public Date getDtEmessoDal() {
		return this.dtEmessoDal;
	}

	public void setDtEmessoDal(Date dtEmessoDal) {
		this.dtEmessoDal = dtEmessoDal;
	}

	public Date getDtRimborsoA() {
		return this.dtRimborsoA;
	}

	public void setDtRimborsoA(Date dtRimborsoA) {
		this.dtRimborsoA = dtRimborsoA;
	}

	public Date getDtRimborsoDa() {
		return this.dtRimborsoDa;
	}

	public void setDtRimborsoDa(Date dtRimborsoDa) {
		this.dtRimborsoDa = dtRimborsoDa;
	}

	public Double getDurata() {
		return this.durata;
	}

	public void setDurata(Double durata) {
		this.durata = durata;
	}

	public Double getIEmesso() {
		return this.iEmesso;
	}

	public void setIEmesso(Double iEmesso) {
		this.iEmesso = iEmesso;
	}

	public Integer getMeseEmissione() {
		return this.meseEmissione;
	}

	public void setMeseEmissione(Integer meseEmissione) {
		this.meseEmissione = meseEmissione;
	}

	public Integer getMeseRimborso() {
		return this.meseRimborso;
	}

	public void setMeseRimborso(Integer meseRimborso) {
		this.meseRimborso = meseRimborso;
	}

	public Double getPctBot() {
		return this.pctBot;
	}

	public void setPctBot(Double pctBot) {
		this.pctBot = pctBot;
	}

	public Double getPctCedola() {
		return this.pctCedola;
	}

	public void setPctCedola(Double pctCedola) {
		this.pctCedola = pctCedola;
	}
	
	

}