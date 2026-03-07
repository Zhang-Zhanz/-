package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {
    @Select("select * from sky_take_out.employee where username=#{username}")
    Employee getByUsername(String username);
    @Insert("insert into sky_take_out.employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user) " +
            "VALUES " +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Employee employee);


    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
    @Select("select * from sky_take_out.employee where id=#{id}")
    Employee getById(Long empId);

    @Update(" update sky_take_out.employee\n" +
            "        set password = #{newPassword},\n" +
            "            update_time = now(),update_user=#{empId} -- 可选：更新修改时间\n" +
            "        where id = #{empId}")
    void updatePassword(Long empId, String newPassword);

    @Update(" update sky_take_out.employee\n" +
            "        set status = #{status},\n" +
            "            update_time = now(),update_user=#{updateUser} -- 可选：更新修改时间\n" +
            "        where id = #{id}")
    void updateStatus(Integer status, Long id,String updateUser);

    void update(Employee employee);
}
