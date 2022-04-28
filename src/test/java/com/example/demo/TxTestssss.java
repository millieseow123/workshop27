package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TxTestssss {
    
    @Autowired
    private AccountRepository accRepo;

    @Autowired
    private AccountService accSvc;

    @Test
	void shouldFindFred() {
		Optional<Account> opt = accRepo.findAccount("Testing");
		assertTrue(opt.isPresent());}


    @Test
	public void notTransactional() {
		accSvc.transfer("Testing", "Testing4", 500f);
		assertTrue(true);
    }

}
