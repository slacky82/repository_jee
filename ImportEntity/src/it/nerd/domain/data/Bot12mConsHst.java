package it.nerd.domain.data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BOT12M_CONS_HST database table.
 * 
 */
@Entity
@Table(name="BOT12M_CONS_HST")
@NamedQuery(name="Bot12mConsHst.findAll", query="SELECT b FROM Bot12mConsHst b")
public class Bot12mConsHst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String annomese;

	@Column(name="PCT_BOT")
	private BigDecimal pctBot;

	public Bot12mConsHst() {
	}

	public String getAnnomese() {
		return this.annomese;
	}

	public void setAnnomese(String annomese) {
		this.annomese = annomese;
	}

	public BigDecimal getPctBot() {
		return this.pctBot;
	}

	public void setPctBot(BigDecimal pctBot) {
		this.pctBot = pctBot;
	}

}