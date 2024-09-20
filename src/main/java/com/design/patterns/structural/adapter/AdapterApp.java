package com.design.patterns.structural.adapter;

import com.design.patterns.structural.adapter.service.AccountService;
import com.design.patterns.structural.adapter.service.impl.ExternalPayment;
import com.design.patterns.structural.adapter.service.impl.PaymentAdapter;
import com.design.patterns.structural.adapter.service.impl.SavingsAccount;

public class AdapterApp {

  public static void main(String[] args) {
    AccountService accountService = new SavingsAccount();
    accountService.deposit(1500.00);
    ExternalPayment externalPayment = new ExternalPayment();

    PaymentAdapter paymentAdapter = new PaymentAdapter(externalPayment, accountService);
    paymentAdapter.make(500.00);
    paymentAdapter.make(2000.00);
  }
}
