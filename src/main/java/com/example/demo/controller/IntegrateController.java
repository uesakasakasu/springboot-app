package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.SearchResultDto;
import com.example.demo.form.DeleteForm;
import com.example.demo.form.InputForm;
import com.example.demo.form.SearchForm;
import com.example.demo.service.DeleteService;
import com.example.demo.service.RegisterService;
import com.example.demo.service.SearchService;
import com.example.demo.service.UpdateService;

/**
 * 検索コントローラ
 */
@Controller
public class IntegrateController {

		// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	@Autowired
	SearchService search;
	@Autowired
	RegisterService register;
	@Autowired
	UpdateService update;
	@Autowired
	DeleteService delete;

	/**
	 * 全件検索処理
	 * @param form
	 * @param model
	 * @return integrate/integrate.html
	 */
	@GetMapping("selectAll")
	private String selectAll(@ModelAttribute Model model) {
		logger.debug("selectAll");
		List<SearchResultDto> resultList = search.executeAll();

		model.addAttribute("resultList", resultList);
		return "integrate/integrate";
	}
	
	/**
	 * ID検索処理
	 * @param form
	 * @param personId, model
	 * @return integrate/integrate.html
	 */
	@GetMapping("searchItg")
	private String search(@RequestParam Integer personId, Model model) {
		logger.debug("searchItg");
		List<SearchResultDto> resultList = search.executeById(personId);
		model.addAttribute("resultList", resultList);
		return "integrate/integrate";
	}
	
	/**
	 * 詳細情報表示処理
	 * @param form
	 * @param id, model
	 * @return integrate/detail.html
	 */
	@GetMapping("detail/{id}")
	private String detailPerson(@PathVariable Integer id, Model model) {
		logger.debug("detailPerson");
		//List<Person> result = search.getPersonById(id);
		List<SearchResultDto> resultList = search.executeById(id);
		model.addAttribute("resultList", resultList);
		return "integrate/detail";
	}
	
	/**
	 * 登録処理
	 * @param form
	 * @return register/complete.html
	 */
	@PostMapping("registerItg")
	private String registerItg(@ModelAttribute InputForm form) {
		logger.debug("register");
		register.execute(form);
        // return "integrate/integrate";
		return "redirect:/integrate/integrate";
	}
	
	/**
	 * 更新処理
	 * @param form
	 * @return update/complete.html
	 */
	@PostMapping("updateItg")
	private String updateItg(@ModelAttribute SearchForm form) {
		logger.debug("update");
		update.execute(form);
		return "integrate/integrate";
	}
	
	/**
	 * 削除処理
	 * @param form
	 * @return delete/complete.html
	 */
	@PostMapping("deleteItg")
	private String deleteItg(@ModelAttribute DeleteForm form) {
		logger.debug("delete");
		delete.execute(form);
		return "integrate/integrate";
	}

}
