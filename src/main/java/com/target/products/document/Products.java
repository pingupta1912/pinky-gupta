package com.target.products.document;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Products {

    @Id
    @NotEmpty
    private String id;
    
    @NotEmpty
    private String name;
    
    @NotNull
    private Price price;

    public Products() {
		super();
	}

	public Products(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Products(String id, String name, Price price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

}
