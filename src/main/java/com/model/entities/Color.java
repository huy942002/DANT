package com.model.entities;

import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;


/**
 * The persistent class for the colors database table.
 * 
 */
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="colors")
@NamedQuery(name="Color.findAll", query="SELECT c FROM Color c")
public class Color implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="color_name")
	private String colorName;

	private String img;

}