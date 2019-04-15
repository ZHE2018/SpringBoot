package com.example.demo.mapper;

import com.example.demo.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface BookMapper {
    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBookById(Integer id);
    Book queryBookById(Integer id);
    List<Book> queryBooksByName(String name);
    List<Book> allBooks();
}
