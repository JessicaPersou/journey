package com.persou.journey.employer.datasources.model;

import com.persou.journey.employer.entities.enums.DepartmentSection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department")
public class DepartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private DepartmentSection section;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;
    @OneToMany(mappedBy = "department")
    private List<EmployeeModel> employeeList;

    public DepartmentModel(){}

    public DepartmentModel(String id, String name, String description, DepartmentSection section, boolean active,
                           CompanyModel company, List<EmployeeModel> employeeList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.section = section;
        this.active = active;
        this.company = company;
        this.employeeList = employeeList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DepartmentSection getSection() {
        return section;
    }

    public void setSection(DepartmentSection section) {
        this.section = section;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    public List<EmployeeModel> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeModel> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "DepartmentModel{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", section=" + section +
            ", active=" + active +
            ", company=" + company +
            ", employeeList=" + employeeList +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DepartmentModel that = (DepartmentModel) o;
        return active == that.active && Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) && Objects.equals(description, that.description) &&
            section == that.section && Objects.equals(company, that.company) &&
            Objects.equals(employeeList, that.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, section, active, company, employeeList);
    }
}
