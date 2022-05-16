package com.phone.book.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.phone.book.entity.ContactDetails;

public class ContactSpecification {

	private ContactSpecification() {

	}

	/**
	 * filter contact based on all serach criteria
	 *
	 * @author vivek
	 * @return
	 */

	public static final Specification<ContactDetails> getContactFilter(final String firstName,
			String lastName,String middleName,String phoneNumber,String countryCode) {

		return new Specification<ContactDetails>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ContactDetails> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {

				final List<Predicate> predicates = new ArrayList<>();

				if (lastName != null && !lastName.isEmpty()) {
					predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%"));

				}
				
				if (firstName != null && !firstName.isEmpty()) {
					predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + lastName + "%"));

				}
				
				
				if (middleName != null && !middleName.isEmpty()) {
					predicates.add(criteriaBuilder.like(root.get("middleName"), "%" + lastName + "%"));

				}

				
				predicates.add(criteriaBuilder.equal(root.get("phoneNumber"),phoneNumber));
				
				predicates.add(criteriaBuilder.equal(root.get("countryCode"),countryCode));



				query.distinct(true);
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

}
