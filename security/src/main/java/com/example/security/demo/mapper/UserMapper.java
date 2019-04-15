package com.example.security.demo.mapper;
import java.util.List;
import com.example.security.demo.dao.Role;
import com.example.security.demo.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User loadUserByUserName(@Param("username")String username);
    @Select("select * from role r,user_role ur where r.id=ur.id and ur.uid=#{uid}")
    List<Role> getUserRoleByUid(@Param("uid") Integer uid);
}
