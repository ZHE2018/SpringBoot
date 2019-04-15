package com.example.ehcahe.ehcahe.book;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "book")
public class BookRepository {
    /**
     * @Cacheable 开启缓存 开启缓存的方法 会先用key 查询缓存，如果缓存存在则不会执行方法
     * @param id
     * @return
     */
    @Cacheable(key = "#id")
    public Book getBookById(Integer id){
        System.out.println("getBookById");
        //模拟数据库操作
        Book book=new Book();
        book.setId(id);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        return book;
    }

    /**
     * @CachePut注解用于更新方法，被注解的方法不会再执行前查看缓存，而是直接执行，将结果填入缓存
     * 如果key指定的结果在缓存中，则会被覆盖
     * @param book
     * @return
     */
    @CachePut(key="#book.id")
    public Book updateBookById(Book book){
        System.out.println("update");
        book.setName("new"+book.getName());
        return book;
    }

    /**
     * @CacheEvict注解用于删除方法，执行该方法会删除对应的缓存
     *  *allEntries 是否移除所有缓存 默认 false
     *  *befourInvocation 是否在方法执行前移除缓存 默认 false
     * @param id
     */
    @CacheEvict(key="#id")
    public void deleteBookById(Integer id){
        System.out.println("delete"+id.toString());
    }
}
