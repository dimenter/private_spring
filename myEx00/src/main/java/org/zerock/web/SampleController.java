package org.zerock.web;

import javax.inject.Inject;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

	@RequestMapping("/doA")
	public void doA() {
		logger.info("do A called....");
	}

	@RequestMapping("/doB")
	public void doB() {
		logger.info("doB called");
	}

	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC called");
		return "result";// "result.jsp"
	}

	@RequestMapping("/doD")
	public String doD(Model model) {
		ProductVO product = new ProductVO("Sample Product", 10000);
		logger.info("doD");
		model.addAttribute(product);
		return "productDetail";
	}

	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("redirect");
		rttr.addFlashAttribute("msg", "This is the Mesage !! with redirected");

		return "redirect:/doF";

	}

	@RequestMapping("/doF")
	public void doF(String msg) {
		logger.info("doF" + msg);
	}

	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
		ProductVO vo = new ProductVO("샘플상품", 30000);

		return vo;
	}

}
