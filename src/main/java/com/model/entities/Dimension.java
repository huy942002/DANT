package com.model.entities;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
/**
 * The persistent class for the dimensions database table.
 * 
 */
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="dimensions")
@NamedQuery(name="Dimension.findAll", query="SELECT d FROM Dimension d")
public class Dimension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String size;

}