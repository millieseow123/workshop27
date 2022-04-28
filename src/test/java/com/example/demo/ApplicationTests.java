package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ApplicationTests {

	@Autowired
	private AccountRepository accRepo;

	@Autowired
	private AccountService accSvc;

	// @Test
	// public void depositShouldSucceed() {

	// 	Mockito.when(accRepo.withdraw(500, "Testing")).thenThrow(IllegalArgumentException.class);

	// 	assertThrows(IllegalArgumentException.class,
	// 			() -> accSvc.transfer("Testing", "Testing4", 1000f));

	// }

	@Test
	void shouldFindTesting() {
		Optional<Account> opt = accRepo.findAccount("Testing");
		assertTrue(opt.isPresent());
	}

	@Test
	public void notTransactional() {
		accSvc.transfer("Testing", "Testing1", 50f);
		assertTrue(true);
	}

	// @Test
	// public void notTransactional2() {
	// 	accSvc.transfer("Testing", "Testing4", 500f);
	// 	assertFalse(true);
    // }

	// @Test
	// public void shouldFindTesting() {
	// 	Optional<Account> opt = accRepo.findAccount("Testing4");
	// 	assertTrue(opt.isPresent());
	// }


		
}
