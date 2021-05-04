package com.example.laboratorio4.repository;

import com.example.laboratorio4.Dtos.ReporteMayorSalarioDto;
import com.example.laboratorio4.Dtos.ReportePorDepartamento;
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {


    @Query(value = "select e.first_name, e.last_name, DATE_FORMAT(e.hire_date, '%d-%m-%Y') as 'inicio', DATE_FORMAT(jh.end_date, '%d-%m-%Y') as 'fin', j.job_title\n" +
            "from employees e\n" +
            "inner join job_history jh on (e.employee_id=jh.employee_id)\n" +
            "inner join jobs j on (e.job_id=j.job_id)\n" +
            "where salary > 8000", nativeQuery = true)
    List<ReporteMayorSalarioDto> obtenerListaReporteMayorSalario();


    @Query(value = "select departments.department_id, departments.department_name, truncate(avg(employees.salary),0) as salary \n" +
            "from departments, employees where employees.department_id=departments.department_id \n" +
            "group by department_id", nativeQuery = true)
    List<ReportePorDepartamento> obtenerListaReportePorDepartamento();


    @Query(value = "select e.first_name, e.last_name, DATE_FORMAT(e.hire_date, '%d-%m-%Y') as 'inicio', DATE_FORMAT(jh.end_date, '%d-%m-%Y') as 'fin', j.job_title\n" +
            "from employees e\n" +
            "inner join job_history jh on (e.employee_id=jh.employee_id)\n" +
            "inner join jobs j on (e.job_id=j.job_id)\n" +
            "where salary = ?", nativeQuery = true)

    List<ReporteMayorSalarioDto> busquedaPorSalario(int salary);


}
