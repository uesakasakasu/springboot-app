package com.example.demo.form;

import java.io.Serializable;

import lombok.Data;

/**
 * 登録画面form
 */
@Data
public class InputForm implements Serializable {
	private String name;
	private Integer age;
	private Integer gender;
	private String tel;
	private String mail;
}
