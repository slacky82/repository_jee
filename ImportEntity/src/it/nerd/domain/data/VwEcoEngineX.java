package it.nerd.domain.data;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the VW_ECO_ENGINE_X database table.
 * 
 */
@Entity
@Table(name="VW_ECO_ENGINE_X")
@NamedQuery(name="VwEcoEngineX.findAll", query="SELECT v FROM VwEcoEngineX v")
public class VwEcoEngineX implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VwEcoEngineXPK id;	
	
	private Double alfatot;	

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
	@Column(name="DT_INS")
	private Date dtIns;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_RIMBORSO_A")
	private Date dtRimborsoA;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_RIMBORSO_DA")
	private Date dtRimborsoDa;

	@Column(name="IMP_EMESSO")
	private Double impEmesso;

	@Column(name="IMP_RIMBORSO")
	private Double impRimborso;

	@Column(name="IMP_STOCK")
	private Double impStock;	

	@Column(name="PCT_BOT")
	private Double pctBot;

	@Column(name="PCT_CEDOLA")
	private Double pctCedola;

	@Column(name="PCT_CEDOLA_EMISSIONE")
	private Double pctCedolaEmissione;

	public VwEcoEngineX() {
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

	public Date getDtIns() {
		return this.dtIns;
	}

	public void setDtIns(Date dtIns) {
		this.dtIns = dtIns;
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

	public Double getImpEmesso() {
		return this.impEmesso;
	}

	public void setImpEmesso(Double impEmesso) {
		this.impEmesso = impEmesso;
	}

	public Double getImpRimborso() {
		return this.impRimborso;
	}

	public void setImpRimborso(Double impRimborso) {
		this.impRimborso = impRimborso;
	}

	public Double getImpStock() {
		return this.impStock;
	}

	public void setImpStock(Double impStock) {
		this.impStock = impStock;
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

	public Double getPctCedolaEmissione() {
		return this.pctCedolaEmissione;
	}

	public void setPctCedolaEmissione(Double pctCedolaEmissione) {
		this.pctCedolaEmissione = pctCedolaEmissione;
	}

	public VwEcoEngineXPK getId() {
		return id;
	}

	public void setId(VwEcoEngineXPK id) {
		this.id = id;
	}
	
	

}