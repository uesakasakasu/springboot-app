package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mybatis.entity.Person;
import com.example.demo.mybatis.mapper.PersonMapper;

/**
 * サンプルサービス
 */
@Service
public class SampleService {

	// ★マッパークラスをDI
	@Autowired
	PersonMapper mapper;

	/**
	 * 全件取得処理
	 * @return 取得結果
	 */
	public List<Person> selectAll(){
		//　★マッパー（select）実行
		List<Person> retList = mapper.selectAll();
		return retList;
	}
}
