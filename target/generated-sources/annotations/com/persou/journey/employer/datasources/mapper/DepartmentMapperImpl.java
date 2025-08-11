package com.persou.journey.employer.datasources.mapper;

import com.persou.journey.employer.datasources.model.CompanyModel;
import com.persou.journey.employer.datasources.model.DepartmentModel;
import com.persou.journey.employer.entities.Address;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.entities.Department;
import com.persou.journey.employer.transportlayers.response.AddressResponse;
import com.persou.journey.employer.transportlayers.response.CompanyResponse;
import com.persou.journey.employer.transportlayers.response.DepartmentResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-11T13:45:33-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentResponse mapToResponse(Department domain) {
        if ( domain == null ) {
            return null;
        }

        DepartmentResponse.DepartmentResponseBuilder departmentResponse = DepartmentResponse.builder();

        departmentResponse.id( domain.id() );
        departmentResponse.name( domain.name() );
        departmentResponse.description( domain.description() );
        departmentResponse.section( domain.section() );
        departmentResponse.active( domain.active() );
        departmentResponse.company( companyToCompanyResponse( domain.company() ) );

        return departmentResponse.build();
    }

    @Override
    public DepartmentModel mapToEntity(Department domain) {
        if ( domain == null ) {
            return null;
        }

        DepartmentModel departmentModel = new DepartmentModel();

        departmentModel.setId( domain.id() );
        departmentModel.setName( domain.name() );
        departmentModel.setDescription( domain.description() );
        departmentModel.setSection( domain.section() );
        departmentModel.setActive( domain.active() );
        departmentModel.setCompany( companyToCompanyModel( domain.company() ) );

        return departmentModel;
    }

    @Override
    public Department mapToDomain(DepartmentResponse response) {
        if ( response == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.id( response.id() );
        department.name( response.name() );
        department.description( response.description() );
        department.section( response.section() );
        department.active( response.active() );
        department.company( companyResponseToCompany( response.company() ) );

        return department.build();
    }

    @Override
    public Department mapToDomain(DepartmentModel model) {
        if ( model == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.id( model.getId() );
        department.name( model.getName() );
        department.description( model.getDescription() );
        department.section( model.getSection() );
        department.active( model.isActive() );
        department.company( companyModelToCompany( model.getCompany() ) );

        return department.build();
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

    protected com.persou.journey.employer.datasources.model.valueObject.Address addressToAddress(Address address) {
        if ( address == null ) {
            return null;
        }

        com.persou.journey.employer.datasources.model.valueObject.Address.AddressBuilder address1 = com.persou.journey.employer.datasources.model.valueObject.Address.builder();

        address1.street( address.street() );
        address1.number( address.number() );
        address1.neighborhood( address.neighborhood() );
        address1.zipcode( address.zipcode() );
        address1.city( address.city() );
        address1.state( address.state() );
        address1.country( address.country() );

        return address1.build();
    }

    protected CompanyModel companyToCompanyModel(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyModel.CompanyModelBuilder companyModel = CompanyModel.builder();

        companyModel.id( company.id() );
        companyModel.name( company.name() );
        companyModel.cnpj( company.cnpj() );
        companyModel.address( addressToAddress( company.address() ) );
        companyModel.phone( company.phone() );
        companyModel.email( company.email() );

        return companyModel.build();
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
}
