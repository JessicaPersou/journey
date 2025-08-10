package com.persou.journey.employer.datasources.model;

import com.persou.journey.employer.datasources.model.valueObject.Address;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
//    quantidade de horas semanais
//    quantidade de dias de trabalho
//    gestor responsável
}
