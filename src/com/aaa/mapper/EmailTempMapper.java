package com.aaa.mapper;

import com.aaa.model.EmailTemp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/*
@author lzw
@create 2020/9/26 23:21
*/
@Component
public interface EmailTempMapper {
    @Select("select id,fromEmail,fromEmailPassword,emailHost,emailSubject,emailContext1,emailContext2,createTime from emailFromInfo where id=#{id}")
    public EmailTemp getEmailTempById(@Param("id") Integer id);
}
