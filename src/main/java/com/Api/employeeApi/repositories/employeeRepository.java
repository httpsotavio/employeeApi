package com.Api.employeeApi.repositories;
import com.Api.employeeApi.models.employeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface employeeRepository extends JpaRepository<employeeModel, UUID> {
    boolean existsByName(String name);

    @Query("SELECT e FROM employeeModel e WHERE e.name = :name")
    employeeModel findByName(@Param("name") String name);
}
