package com.cts.springBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexHtml {
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/viewproduct")
	public String productView() {
		return "viewproduct";
	}
	
	@RequestMapping(value = "/addProduct")
	public String addProduct(){
		return "addProducts";
	}
}
