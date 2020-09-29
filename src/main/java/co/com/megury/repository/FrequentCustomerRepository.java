package co.com.megury.repository;

import co.com.megury.domain.FrequentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrequentCustomerRepository extends JpaRepository<FrequentCustomer, Long> {
}
