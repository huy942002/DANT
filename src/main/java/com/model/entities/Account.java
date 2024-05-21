package com.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@SuppressWarnings("serial")
@Table
@Data
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String fullname;

	private String password;

	//bi-directional many-to-one association to Authority
	@JsonIgnore
	@OneToMany(mappedBy="account" , fetch = FetchType.EAGER)
	private List<Authority> authorities;

}