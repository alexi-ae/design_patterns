package com.design.patterns.structural.adapter.service.impl;

import com.design.patterns.structural.adapter.service.AccountService;
import com.design.patterns.structural.adapter.service.PaymentService;

public class PaymentAdapter implements PaymentService {

  private ExternalPayment externalPayment;
  private AccountService accountService;

  public PaymentAdapter(ExternalPayment externalPayment, AccountService accountService) {
    this.externalPayment = externalPayment;
    this.accountService = accountService;
  }

  @Override
  public void make(double amount) {
    externalPayment.process(amount);
    accountService.withdraw(amount);
  }
}
