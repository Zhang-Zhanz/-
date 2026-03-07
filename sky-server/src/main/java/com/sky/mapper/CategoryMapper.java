package com.sky.mapper;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface CategoryMapper {
    @Insert("insert into sky_take_out.category (id, type, name, sort, status, create_time, update_time, create_user, update_user) " +
            "VALUES" +
            "(#{id},#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser}) ")
    void insert(Category category);

    List<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    List<Category> list(String type);

    void update(Category category);
    @Delete("delete from sky_take_out.category  where id=#{id}")
    void deleteById(Long id);
}
