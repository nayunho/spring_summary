package com.lec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.lec.controller.BoardController;

@SpringBootApplication
// @ComponentScan(basePackages = {"xxx.lec", "yyy.test", "com.lec"})
public class Lecc01BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lecc01BasicApplication.class, args);
		// BoardController boardController = new BoardController();
	}

}
