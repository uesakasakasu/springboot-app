package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.DeleteForm;
import com.example.demo.form.PersonForm;
import com.example.demo.service.SearchService;

/**
 * メニューコントローラ
 */
@Controller
public class MenuController {

	// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");
	
	@Autowired
	SearchService search;

	/**
	 * メニュー画面表示
	 * @return menu/menu.html
	 */
	@GetMapping("/")
	private String menu() {
		logger.debug("menu");
		return "menu/menu";
	}
	
	/**
	 * 登録画面表示
	 * @return register/input.html
	 */
	@GetMapping("showRegister")
	private String showRegister() {
		logger.debug("showRegister");
		return "register/input";
	}
	
	/**
	 * 検索画面表示
	 * @param model
	 * @return search/search.html
	 */
	@GetMapping("showSearch")
	private String showSearch(@ModelAttribute PersonForm form, Model model) {
		logger.debug("showSearch");
		model.addAttribute("display", false);
		return "search/search";
	}
	
	/**
	 * 更新画面表示
	 * @return update/update.html
	 */
	@GetMapping("showUpdate")
	private String showUpdate() {
		logger.debug("showUpdate");
		return "update/update";
	}
	
	/**
	 * 削除画面表示
	 * @return delete/delete.html
	 */
	@GetMapping("showDelete")
	private String showDelete(@ModelAttribute DeleteForm form, Model model) {
		logger.debug("showDelete");
		return "delete/delete";
	}
	
	
}
