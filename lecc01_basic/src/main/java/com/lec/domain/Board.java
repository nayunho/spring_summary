package com.lec.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@ToString
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
// @RequiredArgsConstructor
@Data
public class Board {
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate = new Date();
	private int cnt;
	
}
