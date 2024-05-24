package com.model.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the role database table.
 * 
 */
@SuppressWarnings("serial")
@Table
@Data
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String name;

	//bi-directional many-to-one association to Authority
	@JsonIgnore
	@OneToMany(mappedBy="role", fetch = FetchType.EAGER)
	private List<Authority> authorities;

}