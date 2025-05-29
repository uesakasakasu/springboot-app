package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.define.Gender;
import com.example.demo.dto.SearchResultDto;
import com.example.demo.form.SearchForm;
import com.example.demo.mybatis.entity.Person;
import com.example.demo.mybatis.mapper.PersonMapper;

/**
 * 検索サービス
 */
/**
 * 
 */
@Service
public class SearchService {

	// ロガー
	private final Logger logger = LoggerFactory.getLogger("appLogger");

	@Autowired
	PersonMapper mapper;

	/**
	 * 検索処理実行
	 * @param form
	 * @return List<SearchResultDto>
	 */
	public List<SearchResultDto> execute(SearchForm form) {
		logger.debug("SearchService.execute");
		Person person = formToEntity(form);
		List<Person> personList = mapper.search(person);
		return entityToDto(personList);
	}

	/**
	 * Form to Entity変換処理
	 * @param form
	 * @return Person
	 */
	private Person formToEntity(SearchForm form) {
		Person person = new Person();
		person.setPersonId(form.getPersonId());
		person.setName(form.getName());
		person.setAge(form.getAge());
		person.setGender(form.getGender());
		person.setTel(form.getTel());
		person.setMail(form.getMail());
		return person;
	}

	/**
	 * Entity to DTO変換処理
	 * @param personList
	 * @return List<SearchResultDto>
	 */
	private List<SearchResultDto> entityToDto(List<Person> personList) {
		List<SearchResultDto> resultList = new ArrayList<>();
		for (Person person : personList) {
			SearchResultDto dto = new SearchResultDto();
			dto.setPersonId(person.getPersonId());
			dto.setName(person.getName());
			dto.setAge(person.getAge());
			dto.setGender(Gender.getLabelById(person.getGender()));
			dto.setTel(person.getTel());
			dto.setMail(person.getMail());
			resultList.add(dto);
		}
		return resultList;
	}
}
