package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.DeleteForm;
import com.example.demo.mybatis.mapper.PersonMapper;

/**
 * 削除サービス
 */
/**
 * 
 */
@Service
public class DeleteService {

	// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	@Autowired
	PersonMapper mapper;

	/**
	 * 削除処理実行
	 * @param form
	 */
	public void execute(DeleteForm form) {
		logger.debug("RegisterService.execute");
		Integer personId = formToID(form);

		mapper.delete(personId);
	}

	/**
	 * Form to Entity変換処理
	 * @param form
	 * @return Person
	 */
	private Integer formToID(DeleteForm form) {
		Integer personId = 0;
		personId = form.getPersonId();
		return personId;
	}
}
