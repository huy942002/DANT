package com.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table
@Data
@Entity
@NamedQuery(name="TotalCategory.findAll", query="SELECT t FROM TotalCategory t")
public class TotalCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="totalCategory")
    private List<ProductCategory> productCategories;
}
