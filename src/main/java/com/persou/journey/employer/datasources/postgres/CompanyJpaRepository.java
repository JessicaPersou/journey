package com.persou.journey.employer.datasources.postgres;

import com.persou.journey.employer.datasources.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyJpaRepository extends JpaRepository<CompanyModel, String> {
}
