package com.model.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;


/**
 * The persistent class for the color_details database table.
 * 
 */
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="color_details")
@NamedQuery(name="ColorDetail.findAll", query="SELECT c FROM ColorDetail c")
public class ColorDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;

}