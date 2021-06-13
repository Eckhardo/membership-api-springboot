package com.eki.membership.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eki.membership.persistence.dao.IUserJpaRepository;

@SpringBootTest
class MembershipAppTests {

	@Autowired
	IUserJpaRepository userRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void persistenceWorks() {

		Assertions.assertFalse(userRepo.findAll().isEmpty());

	}
}
