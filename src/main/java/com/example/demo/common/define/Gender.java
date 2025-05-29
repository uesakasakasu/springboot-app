package com.example.demo.common.define;

import java.util.Objects;

import lombok.Getter;

/**
 * 性別enum
 */
@Getter
public enum Gender {

	NONE("", 0), MALE("男性", 1), FEMALE("女性", 2);

	private String label;
	private int id;

	/**
	 * コンストラクタ
	 * @param label
	 * @param id
	 */
	private Gender(String label, int id) {
		this.label = label;
		this.id = id;
	}

	/**
	 * 引数のidに合致するlabelを返却する
	 * @param id
	 * @return label
	 */
	public static String getLabelById(Integer id) {
		if (Objects.nonNull(id)) {
			for (Gender gender : Gender.values()) {
				if (id == gender.getId()) {
					return gender.getLabel();
				}
			}
		}
		return null;
	}
}
