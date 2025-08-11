package com.persou.journey.employer.datasources.model;

import com.persou.journey.employer.datasources.model.valueObject.Address;
import com.persou.journey.employer.entities.enums.Position;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private LocalDate birthdate;
    @Column(unique = true)
    private String cpf;
    private String phone;
    @Embedded
    private Address address;
    private String email;
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    private Position position;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentModel department;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    //    TODO quantidade de horas semanais
    //    TODO quantidade de dias de trabalho
    //    TODO gestor responsável

    public EmployeeModel() {
    }

    public EmployeeModel(String id, String name, LocalDate birthdate, String cpf, String phone, Address address,
                         String email, BigDecimal salary, Position position, DepartmentModel department,
                         CompanyModel company) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.cpf = cpf;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", birthdate=" + birthdate +
            ", cpf='" + cpf + '\'' +
            ", phone='" + phone + '\'' +
            ", address=" + address +
            ", email='" + email + '\'' +
            ", salary=" + salary +
            ", position=" + position +
            ", department=" + department +
            ", company=" + company +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmployeeModel that = (EmployeeModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) &&
            Objects.equals(birthdate, that.birthdate) && Objects.equals(cpf, that.cpf) &&
            Objects.equals(phone, that.phone) && Objects.equals(address, that.address) &&
            Objects.equals(email, that.email) && Objects.equals(salary, that.salary) &&
            position == that.position && Objects.equals(department, that.department) &&
            Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthdate, cpf, phone, address, email, salary, position, department, company);
    }
}
