package com.persou.journey.employer.datasources.postgres;

import com.persou.journey.employer.datasources.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentJpaRepository extends JpaRepository<DepartmentModel, String> {
}
