package com.design.patterns.behavior.command;

import com.design.patterns.behavior.command.receiver.Account;
import com.design.patterns.behavior.command.service.impl.DepositImpl;
import com.design.patterns.behavior.command.service.impl.WithDrawImpl;

public class CommandApp {

  public static void main(String[] args) {
    Account account = new Account(1, 200);

    DepositImpl deposit = new DepositImpl(account, 500);
    WithDrawImpl withDraw = new WithDrawImpl(account, 280);

    Invoker invoker = new Invoker();
    invoker.receiveOperation(deposit);
    invoker.receiveOperation(withDraw);

    invoker.executeOperations();
  }
}
