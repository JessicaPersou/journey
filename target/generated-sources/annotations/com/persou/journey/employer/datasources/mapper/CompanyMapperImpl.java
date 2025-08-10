package com.persou.journey.employer.datasources.mapper;

import com.persou.journey.employer.datasources.model.CompanyModel;
import com.persou.journey.employer.entities.Address;
import com.persou.journey.employer.entities.Company;
import com.persou.journey.employer.transportlayers.request.AddressRequest;
import com.persou.journey.employer.transportlayers.request.CompanyRequest;
import com.persou.journey.employer.transportlayers.response.AddressResponse;
import com.persou.journey.employer.transportlayers.response.CompanyResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-10T00:53:07-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyResponse mapToResponse(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyResponse.CompanyResponseBuilder companyResponse = CompanyResponse.builder();

        companyResponse.id( company.getId() );
        companyResponse.name( company.getName() );
        companyResponse.cnpj( company.getCnpj() );
        companyResponse.address( addressToAddressResponse( company.getAddress() ) );
        companyResponse.phone( company.getPhone() );
        companyResponse.email( company.getEmail() );

        return companyResponse.build();
    }

    @Override
    public Company mapToDomain(CompanyRequest request) {
        if ( request == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.name( request.name() );
        company.cnpj( request.cnpj() );
        company.address( addressRequestToAddress( request.address() ) );
        company.phone( request.phone() );
        company.email( request.email() );

        return company.build();
    }

    @Override
    public CompanyModel mapToEntity(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyModel companyModel = new CompanyModel();

        companyModel.setId( company.getId() );
        companyModel.setName( company.getName() );
        companyModel.setCnpj( company.getCnpj() );
        companyModel.setAddress( addressToAddress( company.getAddress() ) );
        companyModel.setPhone( company.getPhone() );
        companyModel.setEmail( company.getEmail() );

        return companyModel;
    }

    @Override
    public Company toDomain(CompanyModel model) {
        if ( model == null ) {
            return null;
        }

        Company.CompanyBuilder company = Company.builder();

        company.id( model.getId() );
        company.name( model.getName() );
        company.cnpj( model.getCnpj() );
        company.address( addressToAddress1( model.getAddress() ) );
        company.phone( model.getPhone() );
        company.email( model.getEmail() );

        return company.build();
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse.AddressResponseBuilder addressResponse = AddressResponse.builder();

        addressResponse.street( address.getStreet() );
        addressResponse.number( address.getNumber() );
        addressResponse.neighborhood( address.getNeighborhood() );
        addressResponse.zipcode( address.getZipcode() );
        addressResponse.city( address.getCity() );
        addressResponse.state( address.getState() );
        addressResponse.country( address.getCountry() );

        return addressResponse.build();
    }

    protected Address addressRequestToAddress(AddressRequest addressRequest) {
        if ( addressRequest == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.street( addressRequest.street() );
        address.number( addressRequest.number() );
        address.neighborhood( addressRequest.neighborhood() );
        address.zipcode( addressRequest.zipcode() );
        address.city( addressRequest.city() );
        address.state( addressRequest.state() );
        address.country( addressRequest.country() );

        return address.build();
    }

    protected com.persou.journey.employer.datasources.model.valueObject.Address addressToAddress(Address address) {
        if ( address == null ) {
            return null;
        }

        com.persou.journey.employer.datasources.model.valueObject.Address address1 = new com.persou.journey.employer.datasources.model.valueObject.Address();

        address1.setStreet( address.getStreet() );
        address1.setNumber( address.getNumber() );
        address1.setNeighborhood( address.getNeighborhood() );
        address1.setZipcode( address.getZipcode() );
        address1.setCity( address.getCity() );
        address1.setState( address.getState() );
        address1.setCountry( address.getCountry() );

        return address1;
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
}
