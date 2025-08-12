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
import java.util.Objects;


@Entity
@Table(name = "company")
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "tenant_id")
    private String tenantId;
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

    public CompanyModel() {
    }

    public CompanyModel(String id, String tenantId, String name, String cnpj, String fantasyName, Address address,
                        List<DepartmentModel> departmentList, String phone, String email) {
        this.id = id;
        this.tenantId = tenantId;
        this.name = name;
        this.cnpj = cnpj;
        this.fantasyName = fantasyName;
        this.address = address;
        this.departmentList = departmentList;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<DepartmentModel> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<DepartmentModel> departmentList) {
        this.departmentList = departmentList;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CompanyModel{" +
            "id='" + id + '\'' +
            ", tenantId='" + tenantId + '\'' +
            ", name='" + name + '\'' +
            ", cnpj='" + cnpj + '\'' +
            ", fantasyName='" + fantasyName + '\'' +
            ", address=" + address +
            ", departmentList=" + departmentList +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompanyModel that = (CompanyModel) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(tenantId, that.tenantId) &&
            Objects.equals(name, that.name) &&
            Objects.equals(cnpj, that.cnpj) &&
            Objects.equals(fantasyName, that.fantasyName) &&
            Objects.equals(address, that.address) &&
            Objects.equals(departmentList, that.departmentList) &&
            Objects.equals(phone, that.phone) &&
            Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,tenantId, name, cnpj, fantasyName, address, departmentList, phone, email);
    }
}
