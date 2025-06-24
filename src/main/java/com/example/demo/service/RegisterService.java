package com.example.demo.service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.InputForm;
import com.example.demo.mybatis.entity.Person;
import com.example.demo.mybatis.mapper.PersonMapper;

/**
 * 登録サービス
 */
@Service
public class RegisterService {

	// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	@Autowired
	PersonMapper mapper;

	/**
	 * 登録処理実行
	 * @param form
	 */
	public void execute(InputForm form) {
		logger.debug("RegisterService.execute");
		Person person = formToEntity(form);
		mapper.insert(person);
	}

	/**
	 * Form to Entity変換処理
	 * @param form
	 * @return Person
	 */
	private Person formToEntity(InputForm form) {
		Person person = new Person();
		person.setName(form.getName());
		person.setAge(form.getAge());
		person.setGender(form.getGender());
		person.setTel(form.getTel());
		person.setMail(form.getMail());
		person.setInsertUser("testUser"); // 仮で固定値とする
		person.setInsertDatetime(new Timestamp(System.currentTimeMillis()));
		return person;
	}
}
