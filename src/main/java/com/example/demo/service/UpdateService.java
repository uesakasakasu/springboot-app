package com.example.demo.service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.form.PersonForm;
import com.example.demo.mybatis.entity.Person;
import com.example.demo.mybatis.mapper.PersonMapper;

/**
 * 更新サービス
 */
@Service
public class UpdateService {

	// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	@Autowired
	PersonMapper mapper;

	/**
	 * 更新処理実行
	 * @param form
	 */
	public void execute(PersonForm form) {
		logger.debug("UpdateService.execute");
		Person person = formToEntity(form);
		mapper.update(person);
	}

	/**
	 * ユーザー情報更新処理
	 * @param form
	 */
	@Transactional
	public void updatePerson(PersonForm form) {
		Person person = new Person();
		person.setPersonId(form.getPersonId());
		person.setName(form.getName());
		person.setAge(form.getAge());
		person.setGender(form.getGender());
		person.setTel(form.getTel());
		person.setMail(form.getMail());
		person.setInsertUser("testUser"); // 仮で固定値とする
		person.setInsertDatetime(new Timestamp(System.currentTimeMillis()));
		mapper.update(person);
	}

	/**
	 * Form to Entity変換処理
	 * @param form
	 * @return Person
	 */
	private Person formToEntity(PersonForm form) {
		Person person = new Person();
		person.setPersonId(form.getPersonId());
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
