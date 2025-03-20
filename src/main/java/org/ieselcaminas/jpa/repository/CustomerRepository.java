package org.ieselcaminas.jpa.repository;

import org.ieselcaminas.jpa.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
