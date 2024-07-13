package com.amponsem.product_management.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "categories")
@Data
public class Category {
    @Id
    private String id;
    private String name;

}
