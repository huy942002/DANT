package com.model.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@Table(name="banner")
@NamedQuery(name="Banner.findAll", query="SELECT c FROM Banner c")
public class Banner implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="title")
	private String title;

	private String image;

    private String url;
	
	private boolean state; 
}
