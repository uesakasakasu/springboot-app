package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.InputForm;
import com.example.demo.service.RegisterService;

/**
 * 登録コントローラ
 */
@Controller
public class RegisterController {

	// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	@Autowired
	RegisterService register;

	/**
	 * 登録処理
	 * @param form
	 * @return register/complete.html
	 */
	@PostMapping("register")
	private String register(@ModelAttribute InputForm form) {
		logger.debug("register");
		register.execute(form);
		return "register/complete";
	}
}
