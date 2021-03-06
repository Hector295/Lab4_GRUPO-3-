package com.example.laboratorio4.repository;

import com.example.laboratorio4.Dtos.RecursosHumanosDto;
import com.example.laboratorio4.entity.Employees;
import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

    @Query(value = "select e.first_name as 'nombre',e.last_name as 'apellido', j.job_title as 'cargo', DATE_FORMAT(jh.start_date, '%d-%m-%Y') as 'inicio', DATE_FORMAT(jh.end_date, '%d-%m-%Y') as 'fin',\n" +
            "TIMESTAMPDIFF(YEAR,jh.start_date,jh.end_date) as 'anios' ,Mod(TIMESTAMPDIFF(Month,jh.start_date,jh.end_date),12) as 'mes' from employees e \n" +
            "inner join jobs j on j.job_id=e.job_id \n" +
            "inner join job_history jh on e.employee_id=jh.employee_id order by anios desc, mes desc;", nativeQuery = true)
    List<RecursosHumanosDto> historialEmpleados();
}