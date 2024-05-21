package com.model.DTO;

import com.model.entities.ColorDetail;
import com.model.entities.DimensionDetail;
import com.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Product product;
    private List<ColorDetail> colorDetailList;
    private List<DimensionDetail> dimensionDetailList;
}
