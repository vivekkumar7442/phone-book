package com.phone.book.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phone.book.entity.ContactDetails;

@Repository
public interface ContactRepository extends JpaRepository<ContactDetails, Long> {

	ContactDetails findByCountryCodeAndPhoneNumber(String countryCode, String phoneNumber);

	List<ContactDetails> findAll(Specification<ContactDetails> specification);

}
