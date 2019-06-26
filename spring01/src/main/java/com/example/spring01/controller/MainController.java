package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;

@Controller
public class MainController {
	//로깅을 위한 변수
	private static final Logger logger=
			LoggerFactory.getLogger(MainController.class);
	@RequestMapping("/")
	public String main(Model model) {
		//Model에 자료 저장(서블릿의 request 객체에 해당)
		model.addAttribute("message","홈페이지 방문을 환영합니다.");
		return "main";//main.jsp로 포워딩
		//WEB-INF/views/main.jsp
	}
	
	@RequestMapping("gugu.do") //url mapping
	public String gugu(Model model, 
			@RequestParam(defaultValue="2") int dan) {
		
		//int dan=7;
		String result="";
		for(int i=1; i<=9; i++) {
			result += dan + "x" + i + "=" + dan*i + "<br>";
		}
		//모델에 자료 저장
		model.addAttribute("result",result);
		//views/test/gugu.jsp로 포워딩
		return "test/gugu";
	}//gugu()
	
	@RequestMapping("test.do")
	public void test() {
		//void로 하면 메소드 이름과 같은 페이지로 자동 이동
		//WEB-INF/views/test.jsp
		//return "test";
	}//test()
	
	@RequestMapping("/test/doA")
	public String doA(Model model) {
		/*request.setAttribute("message","홈페이지...");
		 * String page="test/doA.jsp";
		 * RequestDispatcher rd=request.getRequestDispatcher(page);
		 * rd.forward(request, response);
		 * 	 */
		//자료 저장
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		//포워딩
		return "test/doA";
	}//doA()
	
	@RequestMapping("test/doB")
	public void doB() {
		//doB.jsp
		logger.info("doB 호출....");
	}//doB()
	
	@RequestMapping("test/doC")
	public ModelAndView doC(){
		Map<String,Object> map=new HashMap<>();
		map.put("product", new ProductDTO("샤프",1000));
		//new ModelAndView("페이지이름", "변수", 값)
		return new ModelAndView("test/doC", "map", map);
	}//doC()
	
	@RequestMapping("test/doD")
	public String doD() {
		/*forward : 주소 그대로, 화면 이동, 대량의 데이터전달
		 * redirect : 주소 변경, 화면 이동, get방식의 소량의 데이터
		 * 스프링은 jsp와는 달리 기본값이 forward이다.
		 */
		return "redirect:/test/doE";
	}//doD()
	
	@RequestMapping("test/doE")
	public void doE() {
		//void이기 때문에 자동적으로 doE.jsp로 포워딩
	}//doE()
	
	/*
	 * @ResponseBody //dto를 json으로 변환
	 * 
	 * @RequestMapping("test/doF") public ProductDTO doF() { return new
	 * ProductDTO("냉장고",5000000); //doF()는 리턴값이 ProductDTO인 dto자체를 test.jsp에 //보내게
	 * 되는데 받는쪽 입장에서 자바스크립트는 //success: function(result){ 의 "result"는 json형식(xml)으로
	 * //받아처리해야하기 때문에 별도의 변환기가 필요하다. //json //ProductDTO -> {"변수":"값", "변수":"값"} }
	 */

}
