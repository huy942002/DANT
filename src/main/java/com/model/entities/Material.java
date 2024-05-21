package com.model.entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the materials database table.
 * 
 */
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="materials")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="materials_id")
	private int materialsId;

	@Column(name="material_name")
	private String materialName;

	private double price;

	//bi-directional many-to-one association to MaterialCategory
	@ManyToOne
	@JoinColumn(name="material_category_id")
	private MaterialCategory materialCategory;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@OneToMany(mappedBy="material")
	private List<Product> products;
}