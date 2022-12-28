package com.infy.springbootrestapicrudapp.app.Homecontroller;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.springbootrestapicrudapp.app.Model.BaseResponse;
import com.infy.springbootrestapicrudapp.app.Model.ProductEntity;
import com.infy.springbootrestapicrudapp.app.Servicei.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")        // 
public class ProductController {

	@Autowired
	ProductService prs;

	@RequestMapping("/")
	public String prelogin() {
		return "PrductController active ";
	}

	
//POST API
	@PostMapping("product")
	public ResponseEntity<BaseResponse<ProductEntity>> addProduct(@RequestBody ProductEntity pre) {
		ProductEntity prod = prs.save(pre);
		BaseResponse<ProductEntity> baseresponse = new BaseResponse<ProductEntity>(200, "Data Saved Succefully", prod); // instance created with constructor intialization																									
		return new ResponseEntity<BaseResponse<ProductEntity>>(baseresponse, HttpStatus.OK);
	}

//GET API	
	@GetMapping("products")
	public ResponseEntity<BaseResponse<Iterable<ProductEntity>>> showProduct() {
		Iterable<ProductEntity> prodlist = prs.showProducts();
		BaseResponse<Iterable<ProductEntity>> baseresponse = new BaseResponse<Iterable<ProductEntity>>(200, "Data Fetched Succefully", prodlist);
		return new ResponseEntity<BaseResponse<Iterable<ProductEntity>>>(baseresponse,HttpStatus.OK) ;
	}

//DELETE API
	@DeleteMapping("product/{productId}")
	public ResponseEntity<BaseResponse<String>> deleteProduct(@PathVariable("productId") Integer id) {

		Optional<ProductEntity> prddb = prs.checkdata(id);
		if (prddb.isPresent()) {
			String response = prs.deleteProduct(id);
			BaseResponse<String> baseresponse = new BaseResponse<String>(200, "Data Deleted Succefully", response);
			return new ResponseEntity<BaseResponse<String>>(baseresponse, HttpStatus.OK);
		}
		BaseResponse<String> baseresponse = new BaseResponse<String>(404, "No Product Found","please provide valid id");
		return new ResponseEntity<BaseResponse<String>>(baseresponse, HttpStatus.NOT_FOUND);
	}

//UPDATE API
	@PutMapping("product/{productId}")
	public ResponseEntity<BaseResponse<ProductEntity>> updateProduct(@RequestBody ProductEntity pre) {
		Optional<ProductEntity> prddb = prs.checkdata(pre.getProductId());
		if(prddb.isPresent()) {
			ProductEntity prod = prs.updateProduct(pre);
			BaseResponse<ProductEntity> baseresponse = new BaseResponse<ProductEntity>(200, "Data Deleted Succefully",prod);
			return new ResponseEntity<BaseResponse<ProductEntity>>(baseresponse, HttpStatus.OK);
		}
		BaseResponse<ProductEntity> baseresponse = new BaseResponse<ProductEntity>(404, "Data Deleted Succefully",null);
		return new ResponseEntity<BaseResponse<ProductEntity>>(baseresponse, HttpStatus.NOT_FOUND);
	}

}
