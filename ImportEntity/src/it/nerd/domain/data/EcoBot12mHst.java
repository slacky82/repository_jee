package it.nerd.domain.data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ECO_BOT12M_HST database table.
 * 
 */
@Entity
@Table(name="ECO_BOT12M_HST")
@NamedQuery(name="EcoBot12mHst.findAll", query="SELECT e FROM EcoBot12mHst e")
public class EcoBot12mHst implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EcoBot12mHstPK id;

	@Column(name="PCT_BOT")
	private BigDecimal pctBot;

	@Column(name="\"TYPE\"")
	private String type;

	public EcoBot12mHst() {
	}

	public EcoBot12mHstPK getId() {
		return this.id;
	}

	public void setId(EcoBot12mHstPK id) {
		this.id = id;
	}

	public BigDecimal getPctBot() {
		return this.pctBot;
	}

	public void setPctBot(BigDecimal pctBot) {
		this.pctBot = pctBot;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}