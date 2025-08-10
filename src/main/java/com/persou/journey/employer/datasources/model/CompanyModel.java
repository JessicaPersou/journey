package com.persou.journey.employer.datasources.model;

import com.persou.journey.employer.datasources.model.valueObject.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder(toBuilder = true)
@Table(name = "company")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(unique = true)
    private String cnpj;
    @Column(name = "fantasy_name")
    private String fantasyName;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "company")
    private List<DepartmentModel> departmentList;
    private String phone;
    private String email;
}
