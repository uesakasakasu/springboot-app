package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.dto.SearchResultDto;
import com.example.demo.form.PersonForm;
import com.example.demo.service.SearchService;

/**
 * 検索コントローラ
 */
@Controller
public class SearchController {

		// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	@Autowired
	SearchService search;

	/**
	 * 検索処理
	 * @param form
	 * @param model
	 * @return search/search.html
	 */
	@GetMapping("search")
	private String search(@ModelAttribute PersonForm form, Model model) {
		logger.debug("search");
		List<SearchResultDto> resultList = search.execute(form);

		model.addAttribute("resultList", resultList);
		return "search/search";
	}

}
