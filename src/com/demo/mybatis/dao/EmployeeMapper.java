package com.demo.mybatis.dao;

import com.demo.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapper {

    public Employee getEmployeeById(Integer id);

    public List<Employee> getEmps();
}
