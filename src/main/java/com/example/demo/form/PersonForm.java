package com.example.demo.form;

import java.io.Serializable;

import lombok.Data;

/**
 * 検索画面form
 */
@Data
public class PersonForm implements Serializable {
	private Integer personId;
	private String name;
	private Integer age;
	private Integer gender;
	private String tel;
	private String mail;
}
