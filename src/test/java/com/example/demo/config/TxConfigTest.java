package com.example.demo.config;

import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.mapper.MemoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@SpringBootTest
class TxConfigTest {

    @Autowired
    private MemoMapper memoMapper;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Test
    public void txTest1() {
        System.out.println("TX Manager : " + transactionManager);
        //트랜잭션의 기본설정값(new DefaultTransactionDefinition())을 Manager로 전달하여
        //트랜잭션을 실행하고 실행된 트랜잭션의 상태값을 반환해서 transactionStatus로 저장
        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            //성공
            memoMapper.insert(new MemoDto(13,"TX_TEST01"));
            //실패(PK오류)
            memoMapper.insert(new MemoDto(13,"TX_TEST01"));

            transactionManager.commit(transactionStatus);
        }catch (Exception e){
            e.printStackTrace();
            transactionManager.rollback(transactionStatus);
        }
    }
}