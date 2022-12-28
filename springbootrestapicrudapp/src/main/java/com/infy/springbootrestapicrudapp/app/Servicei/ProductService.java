package com.infy.springbootrestapicrudapp.app.Servicei;

import java.util.List;
import java.util.Optional;

import com.infy.springbootrestapicrudapp.app.Model.ProductEntity;

public interface ProductService {

	public ProductEntity save(ProductEntity pre);

	public List<ProductEntity> showProducts();

	public String deleteProduct(Integer id);

	public ProductEntity updateProduct(ProductEntity pre);

	public Optional<ProductEntity> checkdata(Integer id);

}
