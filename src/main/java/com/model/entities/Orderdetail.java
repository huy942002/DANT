package com.model.entities;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;
/**
 * The persistent class for the orderdetail database table.
 * 
 */
@SuppressWarnings("serial")
@Data
@Entity
@NamedQuery(name="Orderdetail.findAll", query="SELECT o FROM Orderdetail o")
public class Orderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	private double price;

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	private int quantity;

}