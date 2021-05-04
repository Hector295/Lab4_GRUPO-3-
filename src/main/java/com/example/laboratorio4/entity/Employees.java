package com.example.laboratorio4.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;


@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    @NotBlank(message = "No puede ser vacío")
    private int employeeId;

    @Column(nullable = false)
    @Size(max=20,message = "El nombre no puede tener más de 20 caracteres")
    @NotBlank(message = "No puede ser vacío")
    private String first_name;

    @Column(nullable = false)
    @Size(max=25,message = "El apellido no puede tener más de 25 caracteres")
    @NotBlank(message = "No puede ser vacío")
    private String last_name;

    @Column(nullable = false)
    @Size(max=25,message = "El email no puede tener más de 25 caracteres")
    @NotBlank(message = "No puede ser vacío")
    @Pattern(regexp="^(.+)@(.+)$", message="Ingrese un mail con el formato: 'ejemplo@correo.com'")
    private String email;


    @Column(nullable = false)
    @Size(min=8,message = "El email debe tener un mínimo de 8 caracteres.")
    @NotBlank(message = "No puede ser vacío")
    private String password;

    @Size(max=40,message = "El telefono no puede tener más de 20 caracteres")
    private String phone_number;

    private LocalDateTime hire_date;

    private String job_id;

    @Column(nullable = false)
    @NotBlank(message = "No puede ser vacío")
    @Digits(integer = 8,fraction = 2)
    @Positive (message = "Debe ser mayor a 0")
    private double salary;

    @Digits(integer = 2,fraction = 2)
    private double commission_pct;

    private int manager_id;
    private int departmentId;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public LocalDateTime getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDateTime hire_date) {
        this.hire_date = hire_date;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public double getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(double commission_pct) {
        this.commission_pct = commission_pct;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    private int enabled;
}
