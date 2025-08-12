package com.persou.journey.employer.datasources.postgres;

import com.persou.journey.employer.datasources.model.CompanyModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyJpaRepository extends JpaRepository<CompanyModel, String> {

    @Query("SELECT c FROM CompanyModel c WHERE c.id = :id AND c.tenantId = :tenantId")
    Optional<CompanyModel> findByIdAndTenantId(String id, String tenantId);
}
