package com.design.patterns.creational.abstractfactory.service.impl;

import com.design.patterns.creational.abstractfactory.service.CardService;

public class PersonalCardServiceImpl implements CardService {

  @Override
  public void create() {
    System.out.println("Create card personal");
  }

  @Override
  public void block() {
    System.out.println("Block card personal");
  }
}
