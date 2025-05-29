package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.SearchForm;
import com.example.demo.service.UpdateService;

/**
 * 更新コントローラ
 */
@Controller
public class UpdateController {

	// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	@Autowired
	UpdateService update;

	/**
	 * 更新処理
	 * @param form
	 * @return update/complete.html
	 */
	@PostMapping("update")
	private String register(@ModelAttribute SearchForm form) {
		logger.debug("update");
		update.execute(form);
		return "update/complete";
	}
}
