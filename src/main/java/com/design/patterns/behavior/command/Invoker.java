package com.design.patterns.behavior.command;

import com.design.patterns.behavior.command.service.IOperation;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

  private List<IOperation> operations = new ArrayList<>();

  public void receiveOperation(IOperation iOperation) {
    this.operations.add(iOperation);
  }

  public void executeOperations() {
    this.operations.forEach(x -> x.execute());
    this.operations.clear();
  }
}
