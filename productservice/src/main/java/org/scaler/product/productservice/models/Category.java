package org.scaler.product.productservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel implements Serializable {
    String name;
    String description;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @JsonBackReference
    List<Product> products;
}