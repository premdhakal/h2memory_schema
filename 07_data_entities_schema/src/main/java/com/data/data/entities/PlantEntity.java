package com.data.data.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Nationalized;

import com.data.data.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import ch.qos.logback.classic.ViewStatusMessagesServlet;
@Entity
//Uses InheritanceType.JOINED to store shared fields in 'plant' and unique fields
//in subclass tables
@Inheritance(strategy = InheritanceType.JOINED)
public class PlantEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long Id;
	@JsonView(Views.Public.class)
	@Nationalized //if string can contain foreign lanaguage
	private String name;
	@JsonView(Views.Public.class)
	private BigDecimal price;
	
	@ManyToOne //many plants can belong to one delivery
	 @JoinColumn(name = "delivery_id")  //map the join column in the plant table
	
	private DeliveryEntity delivery;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public PlantEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryEntity getDelivery() {
		return delivery;
	}
	public void setDelivery(DeliveryEntity delivery) {
		this.delivery = delivery;
	}
	public PlantEntity(Long id, String name, BigDecimal price, DeliveryEntity delivery) {
		super();
		Id = id;
		this.name = name;
		this.price = price;
		this.delivery = delivery;
	}

	
}
