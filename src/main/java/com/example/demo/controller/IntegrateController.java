package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.SearchResultDto;
import com.example.demo.form.InputForm;
import com.example.demo.form.PersonForm;
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
	 * 統合画面表示
	 * @return integrate/integrate.html
	 */
	@GetMapping("showIntegrate")
	private String showIntegrate(Model model) {
		logger.debug("showIntegrate");
		model.addAttribute("resultList", search.executeAll());
		return "integrate/integrate";
	}
	
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
	 * ユーザーの詳細情報表示処理
	 * @param form
	 * @param id, model
	 * @return integrate/detail.html
	 */
	@GetMapping("detail/{personId}")
	private String detailPerson(@PathVariable Integer personId, Model model) {
		logger.debug("detailPerson");
		List<SearchResultDto> resultList = search.executeById(personId);
		model.addAttribute("resultList", resultList);
		return "integrate/detail";
	}
	
	/**
	 * ユーザー情報を編集するためのフォーム画面を表示する処理
	 * @param form
	 * @param personId, model
	 * @return integrate/edit.html
	 */
	@GetMapping("edit")
	public String editPerson(@RequestParam Integer personId, Model model) {
		logger.debug("editPerson");
		model.addAttribute("personForm", search.getEditPerson(personId));
		return "integrate/edit";
	}
	
	/**
	 * ユーザー情報更新処理
	 * @param form
	 * @param personId, model
	 * @return showIntegrate
	 */
	@PostMapping("edit")
	public String updatePerson(@ModelAttribute PersonForm personForm, BindingResult bindingResult) {
		logger.debug("updatePerson");
		
		if(bindingResult.hasErrors()) {
			return "edit";
		}
		
		update.updatePerson(personForm);
		return "redirect:/showIntegrate";
	}
	
	/**
	 * ユーザー情報削除処理
	 * PathVariable により、URLの {id} 部分が id パラメータとして取得される。
	 * RedirectAttributesを使用して、削除が成功したか、エラーが発生したかに応じてメッセージを設定し、
	 * リダイレクト先ページ(一覧画面)にメッセージを渡す。
	 * @param form
	 * @param personId, model
	 * @return showIntegrate
	 */
	@GetMapping("/delete/{id}")
	public String deletePerson(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
	    try {
	    	delete.deletePerson(id);
	        redirectAttributes.addFlashAttribute("successMessage", "ユーザー情報が正常に削除されました。");
	    } catch (EmptyResultDataAccessException e) {
	    	// EmptyResultDataAccessException：削除対象が見つからない場合に発生する例外で、エラーメッセージを設定する。
	    	// 「addFlashAttribute」にてフラッシュメッセージを設定している
	        redirectAttributes.addFlashAttribute("errorMessage", "指定されたIDが見つかりませんでした。");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "ユーザー情報の削除に失敗しました。");
	    }
	    return "redirect:/showIntegrate";
	}
	
	/**
	 * ユーザー情報を登録するためのフォーム画面を表示する処理
	 * @param form
	 * @param personId, model
	 * @return integrate/edit.html
	 */
	@GetMapping("addPerson")
	public String showRegisterForm(Model model) {
		logger.debug("showRegisterForm");
		model.addAttribute("inputForm", new InputForm());
		return "integrate/input";
	}
	
	/**
	 * 登録処理
	 * @param form
	 * @return showIntegrate
	 */
	@PostMapping("addPerson")
	private String addPerson(@ModelAttribute InputForm form, Model model, RedirectAttributes redirectAttributes) {
		logger.debug("addPerson");
		try {
			register.execute(form);
			redirectAttributes.addFlashAttribute("successMessage", "ユーザー情報が正常に追加されました。");
		} catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "ユーザー情報の追加に失敗しました。");
	    }
		return "redirect:/showIntegrate";
	}

}
