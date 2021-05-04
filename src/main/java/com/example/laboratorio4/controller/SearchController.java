package com.example.laboratorio4.controller;


import com.example.laboratorio4.entity.Employees;
import com.example.laboratorio4.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }

    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalario (Model model){
        model.addAttribute("listaReporteMayorSalario", employeesRepository.obtenerListaReporteMayorSalario());
        return "Search/lista2";
    }

    /*@PostMapping("/busqueda")
    public String buscar (){

        //COMPLETAR
    }*/

    @GetMapping(value = "/Filtro2")
    public String listaSalarioPorDepartamento (Model model){
        model.addAttribute("listaReportePorDepartamento", employeesRepository.obtenerListaReportePorDepartamento());
        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep(@ModelAttribute("employees") Employees employees, Model model, @RequestParam("id") int id) {
        Optional<Employees> optionalEmployees = employeesRepository.findById(id);
        if (optionalEmployees.isPresent()){
            employees = optionalEmployees.get();
            model.addAttribute("employees", employees);
            model.addAttribute("listaReporteEmpleadosPorDepartamento", employeesRepository.obtenerListaReporteEmpleadosPorDepartamento(id));
        }
        return "/Search/lista3";

    }


}
