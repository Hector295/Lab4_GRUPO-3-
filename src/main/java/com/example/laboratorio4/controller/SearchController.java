package com.example.laboratorio4.controller;


import com.example.laboratorio4.Dtos.ReporteMayorSalarioDto;
import com.example.laboratorio4.entity.Departments;
import com.example.laboratorio4.entity.Employees;
import com.example.laboratorio4.repository.DepartmentsRepository;
import com.example.laboratorio4.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    @GetMapping(value = {"", "/"})
    public String indice() {
        return "Search/indice";
    }

    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalario(Model model) {
        model.addAttribute("listaReporteMayorSalario", employeesRepository.obtenerListaReporteMayorSalario());
        return "Search/lista2";
    }

    @PostMapping("/busqueda")
    public String buscarSalario(@RequestParam("salary") String salary, Model model, RedirectAttributes attributes) {
        try {
            int salario = Integer.parseInt(salary);
            System.out.println(salary);
            List<ReporteMayorSalarioDto> listaEmpleados = employeesRepository.busquedaPorSalario(salario);
            model.addAttribute("listaReporteMayorSalario", listaEmpleados);
            return "Search/lista2";
        } catch (NumberFormatException e) {
            attributes.addFlashAttribute("validacionTexto", "Debe ingresar un número");
            return "redirect:/Search/Salario";
        }

    }

    @GetMapping(value = "/Filtro2")
    public String listaSalarioPorDepartamento(Model model) {
        model.addAttribute("listaReportePorDepartamento", employeesRepository.obtenerListaReportePorDepartamento());
        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep(@ModelAttribute("departments") Departments departments, Model model, @RequestParam("id") int id) {

        Optional<Departments> optionalDepartments = departmentsRepository.findById(id);
        departments = optionalDepartments.get();
        List<Employees> listaEmpleadoD = departments.getListaEmpleadosPorDepartamento();
        model.addAttribute("listaReporteEmpleadosPorDepartamento", listaEmpleadoD);


        return "/Search/lista3";

    }


}
