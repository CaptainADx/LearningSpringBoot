package com.cn.cnkart.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column
	private String name;

	@Column
	private String description;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	private ItemDetails itemDetails;
	
	@OneToMany(mappedBy="item",cascade = CascadeType.ALL)
	@JsonManagedReference
//	@JoinColumn(name="item_id") //This will add extra column to "Item_Review" Table with name "item_id" to represent the corresponding item for that particular review in the row.
	private List<ItemReview> itemReview;
	
	public Item() {
		
	}
	
	public Item(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ItemDetails getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}

	public List<ItemReview> getItemReview() {
		return itemReview;
	}

	public void setItemReview(List<ItemReview> itemReview) {
		this.itemReview = itemReview;
	}
	
	
	
	 
	
	
	
}
