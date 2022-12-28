package com.infy.springbootrestapicrudapp.app.HomeServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.springbootrestapicrudapp.app.HomeRepository.ProductrRepository;
import com.infy.springbootrestapicrudapp.app.Model.ProductEntity;
import com.infy.springbootrestapicrudapp.app.Servicei.ProductService;

@Service
public class ProdustServiceImpl  implements ProductService{

	
	@Autowired
	ProductrRepository prop;
	@Override
	public ProductEntity save(ProductEntity pre) {
	return prop.save(pre);                   // her we also get the respnse code
	}
	
	@Override
	public List<ProductEntity> showProducts() {
	return prop.findAll();
	}
	
	@Override
	public String deleteProduct(Integer id) {
		prop.deleteById(id);
		return "data deleted";	
	}

	@Override
	public ProductEntity updateProduct(ProductEntity pre) {
		return prop.save(pre);
	}

	@Override
	public Optional<ProductEntity> checkdata(Integer id) {
		return prop.findById(id);
	}

}
