package com.example.demo;


import com.example.demo.mapper.BookMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	static final Integer size = 1000;

	@Autowired
	BookMapper mapper;
	List<Integer> testData=new ArrayList<>(size*10000);

	@Test
	public void contextLoads() {


	}
}
