package com.mvctest.mapper;

import com.mvctest.pojo.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper

public interface userMapper {


    @Insert("insert into users values (null,#{username},#{hashpassword},#{salt})")
    boolean insertUser(UserEntity userEntity);

    @Select("select * from users where  username=#{username}")
    UserEntity selectByName(String username);
}
