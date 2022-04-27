package eapli.base.customermanagement.repositories;

import eapli.base.customermanagement.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}