package com.example.ehcahe.ehcahe;

import com.example.ehcahe.ehcahe.book.Book;
import com.example.ehcahe.ehcahe.book.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EhcaheApplicationTests {
	@Autowired
	BookRepository bookRepository;
	@Test
	public void contextLoads() {
		bookRepository.getBookById(1);//在缓存中创建数据，方法会调用
		bookRepository.getBookById(1);//缓存中存在数据，方法不会调用
		bookRepository.deleteBookById(1);//执行方法，删除缓存中数据
		Book b=bookRepository.getBookById(1);//缓存中数据被删除，方法被调用
		System.out.println(b);
		b=new Book();
		b.setName("红楼梦");
		b.setAuthor("曹雪芹");
		b.setId(1);
		bookRepository.updateBookById(b);//执行方法更新数据同时更新缓存
		b=bookRepository.getBookById(1);//缓存中有数据，方法不会调用
		System.out.println(b);
	}
	/*
	 * 输出结果：
	 * getBookById
	 * delete1
	 * getBookById
	 * Book{id=1, name='三国演义', author='罗贯中'}
	 * update
	 * Book{id=1, name='new红楼梦', author='曹雪芹'}
	 */
}
