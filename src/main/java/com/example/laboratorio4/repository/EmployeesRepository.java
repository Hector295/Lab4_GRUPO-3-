package com.example.laboratorio4.repository;

import com.example.laboratorio4.Dtos.ReporteEmpleadosPorDepartamento;
import com.example.laboratorio4.Dtos.ReporteMayorSalarioDto;
import com.example.laboratorio4.Dtos.ReportePorDepartamento;
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {


    @Query(value = "select e.first_name, e.last_name, e.hire_date, jh.end_date, j.job_title\n" +
            "from employees e\n" +
            "inner join job_history jh on (e.employee_id=jh.employee_id)\n" +
            "inner join jobs j on (e.job_id=j.job_id)\n" +
            "where salary > 8000", nativeQuery = true)
    List<ReporteMayorSalarioDto> obtenerListaReporteMayorSalario();


    @Query(value = "select departments.department_id, departments.department_name, truncate(avg(employees.salary),0) as salary \n" +
            "from departments, employees where employees.department_id=departments.department_id \n" +
            "group by department_id", nativeQuery = true)
    List<ReportePorDepartamento> obtenerListaReportePorDepartamento();

    @Query(value = "select employees.employee_id, employees.first_name, employees.last_name, jobs.job_title, \n" +
            "truncate(employees.salary, 0) as salary\n" +
            "from employees, jobs, departments\n" +
            "where employees.job_id=jobs.job_id and employees.department_id= ? ", nativeQuery = true)
    List<ReporteEmpleadosPorDepartamento> obtenerListaReporteEmpleadosPorDepartamento(int id);


}
