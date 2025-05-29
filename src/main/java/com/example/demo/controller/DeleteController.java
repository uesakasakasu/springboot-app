package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.DeleteForm;
import com.example.demo.service.DeleteService;

/**
 * 検索コントローラ
 */
@Controller
public class DeleteController {

		// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	@Autowired
	DeleteService delete;

	/**
	 * 削除処理
	 * @param form
	 * @return delete/complete.html
	 */
	@PostMapping("delete")
	private String register(@ModelAttribute DeleteForm form) {
		logger.debug("delete");
		delete.execute(form);
		return "delete/complete";
	}

}
