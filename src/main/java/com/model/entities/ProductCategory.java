package com.model.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
/**
 * The persistent class for the product_category database table.
 * 
 */
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="product_category")
@NamedQuery(name="ProductCategory.findAll", query="SELECT p FROM ProductCategory p")
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="product_category_name")
	private String productCategoryName;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@OneToMany(mappedBy="productCategory")
	private List<Product> products;

	@ManyToOne
	@JoinColumn(name="total_category_id")
	private TotalCategory totalCategory;
}