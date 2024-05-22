package com.spring.example.app.POJO;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
//import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "Product")
public class ProductEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private Integer id;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "subCategory")
	private String subCategory;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "FK_category", foreignKey = @ForeignKey(name = "fkc_product_category"))
	Category category;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "product_sizes", joinColumns =
	@JoinColumn(name = "product_id", nullable = false))
	@Column(name = "size")
	private Set<String> sizes;
	
	@ElementCollection
	@CollectionTable(name = "product_colors", joinColumns = @JoinColumn(name = "product_id"))
	@Column(name = "color")
	private Set<String> colors;
	
	@ElementCollection
	@CollectionTable(name = "product_photos", joinColumns = @JoinColumn(name = "product_id"))
	@MapKeyColumn(name = "color")
	@Column(name = "photo_url")
	private Map<String, String> photos;
}
