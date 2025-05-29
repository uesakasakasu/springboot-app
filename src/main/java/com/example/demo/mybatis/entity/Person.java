package com.example.demo.mybatis.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * PersonテーブルEntity
 */
@Data // ★lomboKの機能でsetter/getterを自動生成してくれるので実装は不要
public class Person {
	private Integer personId;			// ID
	private String name;				// 名前
	private Integer age;				// 年齢
	private Integer gender;				// 性別
	private String tel;					// 電話番号
	private String mail;				// メールアドレス
	private String insertUser;			// 作成ユーザー
	private Timestamp insertDatetime;	// 作成日時
}
