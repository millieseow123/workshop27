package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.example.demo.model.AccountUtil.*;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accRepo;

    @PostMapping("/create")
    public ModelAndView newAccount(@RequestBody MultiValueMap<String, String> form){
        Account account = convert(form);
        ModelAndView mvc = new ModelAndView();

        try {
            accRepo.newAccount(account);
            mvc.addObject("Message",
                "Account number %s has been successfully created".formatted(account.getAcct_id())); 
        } catch (Exception e) {
            mvc.addObject("message", "Error, account already exists");
            mvc.setStatus(HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        mvc.setViewName("transaction");
        return mvc;
    }
    
    @PostMapping("/deposit")
    public ModelAndView deposit(@RequestBody MultiValueMap<String, String> form){
        //Account account = depositConvert(form);
        ModelAndView mvc = new ModelAndView();        

        try {
            accRepo.deposit(Float.valueOf(form.getFirst("deposit")), form.getFirst("acct_id"));
        } catch (Exception e) {
            mvc.addObject("depositMessage", "Not allowed");
            mvc.setStatus(HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        mvc.setViewName("success");
        return mvc;
    }

    @PostMapping("/withdraw")
    public ModelAndView withdraw(@RequestBody MultiValueMap<String, String> form){
        Account account = withdrawConvert(form);
        ModelAndView mvc = new ModelAndView();        

        try {
            accRepo.withdraw(Float.valueOf(form.getFirst("withdraw")), form.getFirst("acct_id"));
            mvc.addObject("TXmessage",
            "$$ has been withdrawn from account %s".formatted(account.getAcct_id()));
        } catch (Exception e) {
            mvc.addObject("withdrawMessage", "Not allowed");
            mvc.setStatus(HttpStatus.BAD_REQUEST);
            e.printStackTrace();
        }
        mvc.setViewName("success");
        return mvc;
    }
}
