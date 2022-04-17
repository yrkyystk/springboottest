package com.southwind.springboottest.repository;

import com.southwind.springboottest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }
    //添加方法单元测试
    //添加成功说明该方法可用
    @Test
    void save(){
        //new 一个book对象 封装图书和作者的数据
        Book book = new Book();
        book.setName("测试图书1");
        book.setAuthor("测试作者1");
        //调用 bookRepository对象的save方法保存 save对象
        Book book1 = bookRepository.save(book);
        System.out.println(book1);

    }
    //通过id查找用户
    @Test
    void findById(){
        Book findbyid_1 = bookRepository.findById(1).get();
        System.out.println(findbyid_1);
    }

   //修改编辑单元测试
    //修改一个不存在数据,则新增该数据
    @Test
    void update(){
        Book book = new Book();
        book.setId(117);
        book.setName("测试用户117");
        Book update1 = bookRepository.save(book);//判断数据库是否有该数据,有则修改,没有则新增
        System.out.println(update1);
    }
    //修改一个存在的数据
    @Test
    void update1(){
        Book book = new Book();
        book.setId(121);
        book.setName("修改为测试图书11");
        book.setAuthor("修改为测试作者11");
        Book uptate_odata = bookRepository.save(book);
        System.out.println(uptate_odata);
    }
    
    
    //删除一份数据
    // 注意在vue工程文件不可以使用delete作为函数名因为vue生命周期中有delete这个函数
    //在后端函数名为delete无所谓
    //删除id为139的数据
    @Test
    void delete() {
        bookRepository.deleteById(140);
    }
}