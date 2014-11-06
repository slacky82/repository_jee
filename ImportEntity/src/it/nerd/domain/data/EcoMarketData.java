package it.nerd.domain.data;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ECO_MARKET_DATA database table.
 * 
 */
@Entity
@Table(name="ECO_MARKET_DATA")
@NamedQuery(name="EcoMarketData.findAll", query="SELECT e FROM EcoMarketData e")
public class EcoMarketData implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EcoMarketDataPK id;

	@Column(name="TERM_LABEL")
	private String termLabel;

	@Column(name="\"VALUE\"")
	private BigDecimal value;

	public EcoMarketData() {
	}

	public EcoMarketDataPK getId() {
		return this.id;
	}

	public void setId(EcoMarketDataPK id) {
		this.id = id;
	}

	public String getTermLabel() {
		return this.termLabel;
	}

	public void setTermLabel(String termLabel) {
		this.termLabel = termLabel;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}