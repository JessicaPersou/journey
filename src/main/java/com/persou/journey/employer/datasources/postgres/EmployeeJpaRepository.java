package com.persou.journey.employer.datasources.postgres;

import com.persou.journey.employer.datasources.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeModel, String> {
}
