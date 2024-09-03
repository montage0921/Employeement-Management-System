package net.javagudies.ems_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javagudies.ems_backend.entity.Employee;

// Don't forget to extend JpaRepository
// JpaRepository takes two arguments: the entity type and the type of the entity's primary key
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // By extending JpaRepository, we get CRUD methods for free
    // We can also define custom query methods here if needed
}
