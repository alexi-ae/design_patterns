package com.design.patterns.structural.proxy.service.impl;

import com.design.patterns.structural.proxy.service.ConsultAccountService;

public class ConsultAccountServiceProxy implements ConsultAccountService {

  private ConsultAccountService consultAccountService;
  private String client;
  private boolean permission;

  public ConsultAccountServiceProxy(String client, boolean permission) {
    System.out.println("**************************************");
    this.client = client;
    this.permission = permission;
  }

  @Override
  public void showData() {
    if (Boolean.FALSE.equals(permission)) {
      System.out.println(
          "Acceso denegado: no tiene permiso para consultar el saldo del cliente: " + client);
      return;
    }

    if (consultAccountService == null) {
      consultAccountService = new ConsultAccountServiceImpl(client); // Saldo simulado
    }

    System.out.println("El saldo del cliente: " + client + " es: " + getBalance());
  }

  @Override
  public double getBalance() {
    if (Boolean.FALSE.equals(permission)) {
      System.out.println("Acceso denegado: no tiene permiso para consultar el saldo.");
    }
    if (consultAccountService == null) {
      consultAccountService = new ConsultAccountServiceImpl(client); // Saldo simulado
    }
    return consultAccountService.getBalance();
  }
}
