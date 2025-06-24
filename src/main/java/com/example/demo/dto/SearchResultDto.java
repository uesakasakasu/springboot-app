package com.example.demo.dto;

import lombok.Data;

/**
 * 検索結果Dto
 */
@Data
public class SearchResultDto {
	Integer		personId;
	String		name;
	Integer		age;
	String		gender;
	String		tel;
	String		mail;
}
