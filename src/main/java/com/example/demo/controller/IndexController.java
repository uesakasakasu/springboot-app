package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.mybatis.entity.Person;
import com.example.demo.service.SampleService;

/**
 * indexコントローラ
 */
@Controller
public class IndexController {

	// ★サービスクラスをDI
	@Autowired
	SampleService service;

	// 処理結果出力用セパレータ
	private static final String SEPARATOR = ",";

	/**
	 * index
	 * @return　index画面
	 */
	//@GetMapping("/")
	@GetMapping("/index")
	public String index() {
		
		// サービスクラス実行
		List<Person> retList = service.selectAll();

		// 実行結果確認
		System.out.println("★★取得結果★★");

		for (Person ret : retList) {
			System.out.print("person_id：" + ret.getPersonId() + SEPARATOR);
			System.out.print("name：" + ret.getName() + SEPARATOR);
			System.out.print("age：" + ret.getAge() + SEPARATOR);
			System.out.print("gender：" + ret.getGender() + SEPARATOR);
			System.out.print("tel：" + ret.getTel() + SEPARATOR);
			System.out.print("insert_user：" + ret.getInsertUser() + SEPARATOR);
			System.out.println("insert_datetime：" + ret.getInsertDatetime().toString() + SEPARATOR);
		}
		System.out.println("★★★★★★★★");
		return "index";
	}
}
