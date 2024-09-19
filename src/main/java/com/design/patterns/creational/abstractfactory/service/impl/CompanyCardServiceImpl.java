package com.design.patterns.creational.abstractfactory.service.impl;

import com.design.patterns.creational.abstractfactory.service.CardService;

public class CompanyCardServiceImpl implements CardService {

  @Override
  public void create() {
    System.out.println("Create card company");
  }

  @Override
  public void block() {
    System.out.println("Block card company");
  }
}
