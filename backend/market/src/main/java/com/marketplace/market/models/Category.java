package com.marketplace.market.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	@Column(unique=true)
	private String name;

	private double tax;

	private double serviceTax;

	private boolean isTaxApplicable;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	@JsonManagedReference // Include the category when creating the item
	private Set<Item> items;

	public void setTaxApplicable(boolean isTaxApplicable) {
		this.isTaxApplicable = isTaxApplicable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsTaxApplicable() {
		return isTaxApplicable;
	}

	public void setIsTaxApplicable(boolean isTaxApplicable) {
		this.isTaxApplicable = isTaxApplicable;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Category() {
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(double serviceTax) {
		this.serviceTax = serviceTax;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", tax=" + tax + ", serviceTax=" + serviceTax
				+ ", isTaxApplicable=" + isTaxApplicable + "]";
	}

	public Category(int id, String name, double tax, double serviceTax, boolean isTaxApplicable, Set<Item> items) {
		this.id = id;
		this.name = name;
		this.tax = tax;
		this.serviceTax = serviceTax;
		this.isTaxApplicable = isTaxApplicable;
		this.items = items;
	}

}
