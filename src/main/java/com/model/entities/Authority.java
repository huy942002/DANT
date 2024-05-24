package com.model.entities;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
/**
 * The persistent class for the authority database table.
 * 
 */
@SuppressWarnings("serial")
@Table
@Data
@Entity
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="account")
	private Account account;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role")
	Role role;

}