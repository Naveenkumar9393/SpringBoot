package com.cts.springBoot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.productServices.Product;
import com.productServices.ProductService;

/**
 * Rest Controller Class :
 * 
 * @author 748506
 *
 */

// Need to check has-map into JSON object:

@RestController
public class ProductController {


	@Autowired
	ProductService service;

	//get product
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:3045")
	public ResponseEntity<Object> getDetails() {
		return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);

	}
	
	// Create Product:
	@RequestMapping(value = "/createProduct", method = RequestMethod.POST)
	public ResponseEntity<Object> createservice(@RequestBody Product product) {
		service.createProduct(product);
		return new ResponseEntity<>("product created successfully ", HttpStatus.OK);
	}

	// Update Product
	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateservice(@PathVariable("id") String id, @RequestBody Product product) {
		service.updateProduct(id, product);
		return new ResponseEntity<>("product updated successfully ", HttpStatus.OK);
	}

	// Delete Product
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteservice(@PathVariable("id") String id) {
		service.deleteProduct(id);
		return new ResponseEntity<>("product Deleted successfully ", HttpStatus.OK);
	}



	/***
	 * upload File
	 * 
	 * @param uploadfile
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFile(@RequestBody MultipartFile uploadfile) {
		try {
			File file = new File("./src/main/resources/" + uploadfile.getOriginalFilename());
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
			out.write(uploadfile.getBytes());
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "File uploaded successfully ";
	}

	/**
	 * Download File
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downLoadFile() throws FileNotFoundException {
		File file = new File("./src/main/resources/exampleFile.txt");
		InputStreamResource reso = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		ResponseEntity<Object> response = ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(reso);
		return response;
	}

}
