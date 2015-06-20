package com.brassappmanager.persistence.entities;

// Generated Jun 20, 2015 11:05:54 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Instrument generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "instrument", schema = "public")
@SequenceGenerator(name = "instrument_seq", sequenceName = "instrument_id_seq")
public class Instrument implements java.io.Serializable {

	private long id;
	private InstrumentType instrumentType;
	private String serial;
	private String specification;
	private BigDecimal price;
	private String yearOfPricing;
	private Currency currency;
	private Set<Person> persons = new HashSet<>(0);

	public Instrument() {
	}

	public Instrument(InstrumentType instrumentType, String serial,
			String specification, BigDecimal price, String yearOfPricing,
			Currency currency, Set<Person> persons) {
		this.instrumentType = instrumentType;
		this.serial = serial;
		this.specification = specification;
		this.price = price;
		this.yearOfPricing = yearOfPricing;
		this.currency = currency;
		this.persons = persons;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instrument_seq")
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instrument_type_id")
	public InstrumentType getInstrumentType() {
		return this.instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	@Column(name = "serial", length = 100)
	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	@Column(name = "specification", length = 500)
	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	@Column(name = "price", precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "year_of_pricing", length = 20)
	public String getYearOfPricing() {
		return this.yearOfPricing;
	}

	public void setYearOfPricing(String yearOfPricing) {
		this.yearOfPricing = yearOfPricing;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instrument_type_id")
	public Currency getCurrencyId() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "person_instrument", schema = "public", joinColumns = { @JoinColumn(name = "instrument_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "person_id", nullable = false, updatable = false) })
	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

}
