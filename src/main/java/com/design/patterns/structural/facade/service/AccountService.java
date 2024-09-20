package com.design.patterns.structural.facade.service;

public class AccountService {

  public void create(String holder, String type) {
    System.out.println("Cuenta de " + type + " creada para " + holder);
  }
}
