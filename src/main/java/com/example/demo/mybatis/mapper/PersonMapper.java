package com.example.demo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.mybatis.entity.Person;

/**
 * PersonテーブルMapper
 */
// ★mybatisのマッパー。インターフェースで実装し、メソッドは定義するだけ。実際に実行されるSQLはXML側に記載する
// ★各メソッド名はxmlのSQLのIDに該当する
@Mapper
public interface PersonMapper {

	/**
	 * 登録
	 * @param person
	 * @return 登録件数
	 */
	public int insert(Person person);
	
	/**
	 * select
	 * @param person
	 * @return List<Person>
	 */
	public List<Person> search(Person person);
	
	/**
	 * 全件検索
	 * @param person
	 * @return List<Person>
	 */
	public List<Person> selectAll();
	
	/**
	 * 更新
	 * @param person
	 * @return 更新件数
	 */
	public int update(Person person);
	
	/**
	 * 削除
	 * @param id
	 * @return 削除件数
	 */
	public int delete(Integer id);
}
