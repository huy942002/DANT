package com.model.entities;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

import java.util.Date;

/**
 * The persistent class for the rder database table.
 * 
 */
@SuppressWarnings("serial")
@Data
@Entity
@NamedQuery(name="Order.findAll", query="SELECT r FROM Order r")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	private String fullname;

	private String sdt;

}