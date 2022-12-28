package com.infy.springbootrestapicrudapp.app.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	@Id
	private Integer productId;
	private String productName;
	private Double productPrice;
	
}
