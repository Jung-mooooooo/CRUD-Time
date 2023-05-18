package com.crud.btt;

import com.crud.btt.member.entity.JpaMemberRepository;
import com.crud.btt.member.entity.MemberEntity;
import com.crud.btt.member.entity.MemberRepository;
import com.crud.btt.member.model.dto.MemberDto;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class MemberRepositoryTest {

    JpaMemberRepository jpaMemberRepository;

    @Autowired
    MemberRepository memberRepository;
    @Test
    public void insertTest() {
        for (int i = 1; i < 20; i++) {
            MemberEntity memberEntity = MemberEntity.builder()
                    .userCode((long)i)
                    .userName("user"+i)
                    .userId("user"+i)
                    .userPw("pass"+i)
                    .phone("010-1234-000"+i)
                    .email("abcd"+i+"@naver.com")
                    .enrollDate(LocalDateTime.now())
                    .build();

            log.info("member save 전 : " + memberEntity);

            memberRepository.save(memberEntity);

            log.info("member save 후 : " + memberEntity);

        }
    }
}
