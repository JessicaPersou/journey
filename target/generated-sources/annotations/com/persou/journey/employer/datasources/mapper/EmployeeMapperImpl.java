package com.persou.journey.employer.datasources.mapper;

import com.persou.journey.employer.datasources.model.CompanyModel;
import com.persou.journey.employer.datasources.model.DepartmentModel;
import com.persou.journey.employer.datasources.model.EmployeeModel;
import com.persou.journey.employer.entities.Address;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.entities.Department;
import com.persou.journey.employer.entities.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-10T00:53:07-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toDomain(EmployeeModel employeeModel) {
        if ( employeeModel == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeModel.getId() );
        employee.name( employeeModel.getName() );
        employee.birthdate( employeeModel.getBirthdate() );
        employee.cpf( employeeModel.getCpf() );
        employee.phone( employeeModel.getPhone() );
        employee.address( addressToAddress( employeeModel.getAddress() ) );
        employee.email( employeeModel.getEmail() );
        employee.salary( employeeModel.getSalary() );
        if ( employeeModel.getPosition() != null ) {
            employee.position( employeeModel.getPosition().name() );
        }
        employee.department( departmentModelToDepartment( employeeModel.getDepartment() ) );
        employee.company( companyModelToCompany( employeeModel.getCompany() ) );

        return employee.build();
    }

    protected Address addressToAddress(com.persou.journey.employer.datasources.model.valueObject.Address address) {
        if ( address == null ) {
            return null;
        }

        Address.AddressBuilder address1 = Address.builder();

        address1.street( address.getStreet() );
        address1.number( address.getNumber() );
        address1.neighborhood( address.getNeighborhood() );
        address1.zipcode( address.getZipcode() );
        address1.city( address.getCity() );
        address1.state( address.getState() );
        address1.country( address.getCountry() );

        return address1.build();
    }

    protected Company companyModelToCompany(CompanyModel companyModel) {
        if ( companyModel == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.id( companyModel.getId() );
        company.name( companyModel.getName() );
        company.cnpj( companyModel.getCnpj() );
        company.address( addressToAddress( companyModel.getAddress() ) );
        company.phone( companyModel.getPhone() );
        company.email( companyModel.getEmail() );

        return company.build();
    }

    protected Department departmentModelToDepartment(DepartmentModel departmentModel) {
        if ( departmentModel == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.id( departmentModel.getId() );
        department.name( departmentModel.getName() );
        department.description( departmentModel.getDescription() );
        department.section( departmentModel.getSection() );
        department.active( departmentModel.isActive() );
        department.company( companyModelToCompany( departmentModel.getCompany() ) );

        return department.build();
    }
}
