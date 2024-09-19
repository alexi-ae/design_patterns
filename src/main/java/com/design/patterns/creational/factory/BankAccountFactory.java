package com.design.patterns.creational.factory;

import com.design.patterns.creational.factory.models.TypeAccount;
import com.design.patterns.creational.factory.service.BankAccountService;
import com.design.patterns.creational.factory.service.impl.CurrentAccountServiceImpl;
import com.design.patterns.creational.factory.service.impl.PayRollAccountServiceImpl;
import com.design.patterns.creational.factory.service.impl.SavingAccountServiceImpl;
import com.design.patterns.creational.factory.service.impl.TimeDepositAccountServiceImpl;
import java.util.Objects;
import lombok.SneakyThrows;

public class BankAccountFactory {

  @SneakyThrows
  public BankAccountService getBankAccount(String type) {
    System.out.println("********************************************");
    if (Objects.isNull(type)) {
      throw new Exception("Invalid account type");
    }
    System.out.println("BankAccount by type: " + type);
    if (TypeAccount.CURRENT.name().equals(type)) {
      return new CurrentAccountServiceImpl();
    } else if (TypeAccount.PAYROLL.equals(type)) {
      return new PayRollAccountServiceImpl();
    } else if (TypeAccount.TIME_DEPOSIT.equals(type)) {
      return new TimeDepositAccountServiceImpl();
    } else {
      return new SavingAccountServiceImpl();
    }
  }

}
