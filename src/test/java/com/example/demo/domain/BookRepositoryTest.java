package com.example.demo.domain;

import com.example.demo.domain.entity.Book;
import com.example.demo.domain.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void SaveRepo(){
//        System.out.println(bookRepository);
        assertThat(bookRepository).isNotNull(); // Null 이면은 테스트 통과
        Book book = Book.builder()

                .bookcode(1111L)
                .bookname("집에가고싶어요")
                .publisher("백승하미디어")
                .isbn("1111-1111")
                .build();
            assertThat(book).isNotNull();

            //INSERT
        Book result = bookRepository.save(book);
        assertThat(result).isEqualTo(book);
    }
    @Test
    public void UpdateRepo(){
        Book book = Book.builder()
                .bookcode(1117L)
                .bookname("살려주세요")
                .publisher("백승하미디어")
                .isbn("1111-1111")
                .build();
        bookRepository.save(book);

    }
    @Test
    public void DeleteRepo(){
        bookRepository.deleteById(1117L);
    }

    @Test
    public void SelectRepo(){
       List<Book> list = bookRepository.findAll();
       list.forEach(dto->{
           System.out.println(dto);
       });
    }

    @Test
    public void SelectOneRepo(){
        Optional<Book> result = bookRepository.findById(3L);
        Book book = result.get();
        System.out.println(book);
    }

    //함수 추가해서 확인

    @Test
    public void SelectBybookname(){
    List<Book> list = bookRepository.findByBookName("살려주세요");
    list.forEach(dto->{
        System.out.println(dto);
    });
    }

    @Test
    public void SelectByWheres(){
        List<Book> list = bookRepository.findByBookNameAndPublisher("살려주세요","백승하미디어");
        list.forEach(dto->{
            System.out.println(dto);
        });
    }
    @Test
    public void IsContaining(){
        List<Book> list = bookRepository.findByBookNameContaining("살려");
        list.forEach(dto->{
            System.out.println(dto);
        });
    }
}