package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

        // JPA @Query 사용
        // JPA 함수 Naming 부여
        List<Book> findByBookName(String bookname);
        List<Book> findByPublisher(String publisher);
        List<Book> findByIsbn(String isbn);
        List<Book> findByBookNameAndPublisher(String bookname,String publisher);

        //포함문자열 검색
        List<Book> findByBookNameContaining(String bookKeyword);
        List<Book> findByPublisherStartingWith(String prefix);

        // 책이름이 동일한 행의 갯수
        int countByBookName(String bookname);

        // 책이름이 특정 문자열을 포함하는 행의 갯수
        int countByBookNameContaining(String bookname);

        // 책이름으로 삭제
        void deleteByBookName(String bookname);


}
