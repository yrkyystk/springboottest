package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.Book;
import com.southwind.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);
    }

    //添加
    @PostMapping("/save")
    //@RequestBody 由于前端的数据以 json -> 后端 用该注解将数据转为java对象
    public String save(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    //编辑修改
    @PutMapping("/update")
    public String update(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }

    }


    //删除数据
    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }


}
