package com.persou.journey.employer.datasources.mapper;

import com.persou.journey.employer.datasources.model.CompanyModel;
import com.persou.journey.employer.datasources.model.DepartmentModel;
import com.persou.journey.employer.datasources.model.EmployeeModel;
import com.persou.journey.employer.entities.Address;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.entities.Department;
import com.persou.journey.employer.entities.Employee;
import com.persou.journey.employer.entities.enums.Position;
import com.persou.journey.employer.transportlayers.response.AddressResponse;
import com.persou.journey.employer.transportlayers.response.CompanyResponse;
import com.persou.journey.employer.transportlayers.response.DepartmentResponse;
import com.persou.journey.employer.transportlayers.response.EmployeeResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-10T15:59:47-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeResponse mapToResponse(Employee domain) {
        if ( domain == null ) {
            return null;
        }

        EmployeeResponse.EmployeeResponseBuilder employeeResponse = EmployeeResponse.builder();

        employeeResponse.id( domain.id() );
        employeeResponse.name( domain.name() );
        employeeResponse.birthdate( domain.birthdate() );
        employeeResponse.cpf( domain.cpf() );
        employeeResponse.phone( domain.phone() );
        employeeResponse.address( addressToAddressResponse( domain.address() ) );
        employeeResponse.email( domain.email() );
        employeeResponse.salary( domain.salary() );
        employeeResponse.position( domain.position() );
        employeeResponse.department( departmentToDepartmentResponse( domain.department() ) );
        employeeResponse.company( companyToCompanyResponse( domain.company() ) );

        return employeeResponse.build();
    }

    @Override
    public EmployeeModel mapToEntity(Employee domain) {
        if ( domain == null ) {
            return null;
        }

        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setId( domain.id() );
        employeeModel.setName( domain.name() );
        employeeModel.setBirthdate( domain.birthdate() );
        employeeModel.setCpf( domain.cpf() );
        employeeModel.setPhone( domain.phone() );
        employeeModel.setAddress( addressToAddress( domain.address() ) );
        employeeModel.setEmail( domain.email() );
        employeeModel.setSalary( domain.salary() );
        if ( domain.position() != null ) {
            employeeModel.setPosition( Enum.valueOf( Position.class, domain.position() ) );
        }
        employeeModel.setDepartment( departmentToDepartmentModel( domain.department() ) );
        employeeModel.setCompany( companyToCompanyModel( domain.company() ) );

        return employeeModel;
    }

    @Override
    public Employee mapToDomain(EmployeeResponse response) {
        if ( response == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( response.id() );
        employee.name( response.name() );
        employee.birthdate( response.birthdate() );
        employee.cpf( response.cpf() );
        employee.phone( response.phone() );
        employee.address( addressResponseToAddress( response.address() ) );
        employee.email( response.email() );
        employee.salary( response.salary() );
        employee.position( response.position() );
        employee.department( departmentResponseToDepartment( response.department() ) );
        employee.company( companyResponseToCompany( response.company() ) );

        return employee.build();
    }

    @Override
    public Employee mapToDomain(EmployeeModel model) {
        if ( model == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( model.getId() );
        employee.name( model.getName() );
        employee.birthdate( model.getBirthdate() );
        employee.cpf( model.getCpf() );
        employee.phone( model.getPhone() );
        employee.address( addressToAddress1( model.getAddress() ) );
        employee.email( model.getEmail() );
        employee.salary( model.getSalary() );
        if ( model.getPosition() != null ) {
            employee.position( model.getPosition().name() );
        }
        employee.department( departmentModelToDepartment( model.getDepartment() ) );
        employee.company( companyModelToCompany( model.getCompany() ) );

        return employee.build();
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse.AddressResponseBuilder addressResponse = AddressResponse.builder();

        addressResponse.street( address.street() );
        addressResponse.number( address.number() );
        addressResponse.neighborhood( address.neighborhood() );
        addressResponse.zipcode( address.zipcode() );
        addressResponse.city( address.city() );
        addressResponse.state( address.state() );
        addressResponse.country( address.country() );

        return addressResponse.build();
    }

    protected CompanyResponse companyToCompanyResponse(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyResponse.CompanyResponseBuilder companyResponse = CompanyResponse.builder();

        companyResponse.id( company.id() );
        companyResponse.name( company.name() );
        companyResponse.cnpj( company.cnpj() );
        companyResponse.address( addressToAddressResponse( company.address() ) );
        companyResponse.phone( company.phone() );
        companyResponse.email( company.email() );

        return companyResponse.build();
    }

    protected DepartmentResponse departmentToDepartmentResponse(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentResponse.DepartmentResponseBuilder departmentResponse = DepartmentResponse.builder();

        departmentResponse.id( department.id() );
        departmentResponse.name( department.name() );
        departmentResponse.description( department.description() );
        departmentResponse.section( department.section() );
        departmentResponse.active( department.active() );
        departmentResponse.company( companyToCompanyResponse( department.company() ) );

        return departmentResponse.build();
    }

    protected com.persou.journey.employer.datasources.model.valueObject.Address addressToAddress(Address address) {
        if ( address == null ) {
            return null;
        }

        com.persou.journey.employer.datasources.model.valueObject.Address address1 = new com.persou.journey.employer.datasources.model.valueObject.Address();

        address1.setStreet( address.street() );
        address1.setNumber( address.number() );
        address1.setNeighborhood( address.neighborhood() );
        address1.setZipcode( address.zipcode() );
        address1.setCity( address.city() );
        address1.setState( address.state() );
        address1.setCountry( address.country() );

        return address1;
    }

    protected CompanyModel companyToCompanyModel(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyModel companyModel = new CompanyModel();

        companyModel.setId( company.id() );
        companyModel.setName( company.name() );
        companyModel.setCnpj( company.cnpj() );
        companyModel.setAddress( addressToAddress( company.address() ) );
        companyModel.setPhone( company.phone() );
        companyModel.setEmail( company.email() );

        return companyModel;
    }

    protected DepartmentModel departmentToDepartmentModel(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentModel departmentModel = new DepartmentModel();

        departmentModel.setId( department.id() );
        departmentModel.setName( department.name() );
        departmentModel.setDescription( department.description() );
        departmentModel.setSection( department.section() );
        departmentModel.setActive( department.active() );
        departmentModel.setCompany( companyToCompanyModel( department.company() ) );

        return departmentModel;
    }

    protected Address addressResponseToAddress(AddressResponse addressResponse) {
        if ( addressResponse == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.street( addressResponse.street() );
        address.number( addressResponse.number() );
        address.neighborhood( addressResponse.neighborhood() );
        address.zipcode( addressResponse.zipcode() );
        address.city( addressResponse.city() );
        address.state( addressResponse.state() );
        address.country( addressResponse.country() );

        return address.build();
    }

    protected Company companyResponseToCompany(CompanyResponse companyResponse) {
        if ( companyResponse == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.id( companyResponse.id() );
        company.name( companyResponse.name() );
        company.cnpj( companyResponse.cnpj() );
        company.address( addressResponseToAddress( companyResponse.address() ) );
        company.phone( companyResponse.phone() );
        company.email( companyResponse.email() );

        return company.build();
    }

    protected Department departmentResponseToDepartment(DepartmentResponse departmentResponse) {
        if ( departmentResponse == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.id( departmentResponse.id() );
        department.name( departmentResponse.name() );
        department.description( departmentResponse.description() );
        department.section( departmentResponse.section() );
        department.active( departmentResponse.active() );
        department.company( companyResponseToCompany( departmentResponse.company() ) );

        return department.build();
    }

    protected Address addressToAddress1(com.persou.journey.employer.datasources.model.valueObject.Address address) {
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
        company.address( addressToAddress1( companyModel.getAddress() ) );
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
