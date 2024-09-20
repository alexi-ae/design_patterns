package com.design.patterns.structural.proxy;

import com.design.patterns.structural.proxy.service.ConsultAccountService;
import com.design.patterns.structural.proxy.service.impl.ConsultAccountServiceProxy;

public class ProxyApp {

  public static void main(String[] args) {
    ConsultAccountService consultAccountService = new ConsultAccountServiceProxy("123456", true);
    consultAccountService.showData();

    ConsultAccountService consultAccountServiceProxy2 = new ConsultAccountServiceProxy("987654",
        false);
    consultAccountServiceProxy2.showData();
  }
}
