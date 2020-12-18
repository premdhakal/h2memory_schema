package com.data.data.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;
@Entity
public class DeliveryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Nationalized
	private String recipentName;
	@Column(name="address_full",length=500) // only if name is column name is different than refrence
	private String recipentAddress;
	private LocalDateTime deliveryTime;//// includes both date and time - simpler than having two separate fields
	  @Type(type = "yes_no")
	  private Boolean completed;

	//make sure to specify mappedBy. Lazy fetch optional,
	   //  but often a good idea for collection attributes
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "delivery")
	private List<PlantEntity> plantEntity;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getRecipentName() {
		return recipentName;
	}
	public void setRecipentName(String recipentName) {
		this.recipentName = recipentName;
	}
	public String getRecipentAddress() {
		return recipentAddress;
	}
	public void setRecipentAddress(String recipentAddress) {
		this.recipentAddress = recipentAddress;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public DeliveryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryEntity(Long id, String recipentName, String recipentAddress, LocalDateTime deliveryTime,
			Boolean completed) {
		super();
		Id = id;
		this.recipentName = recipentName;
		this.recipentAddress = recipentAddress;
		this.deliveryTime = deliveryTime;
		this.completed = completed;
	}
	
	
	
}
