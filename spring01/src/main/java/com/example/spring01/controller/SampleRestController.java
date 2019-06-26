package com.example.spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring01.model.dto.ProductDTO;

//Spring 4.0부터 사용 가능
//@RestController은 뷰를 리턴하는 것이 아닌 json을 리턴
@RestController
public class SampleRestController {
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		return new ProductDTO("냉장고",3000000);
	}

}
