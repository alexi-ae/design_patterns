package com.design.patterns.creational.abstractfactory;

import com.design.patterns.creational.abstractfactory.models.CustomerType;
import com.design.patterns.creational.abstractfactory.service.FinancialProductAbstractFactory;
import com.design.patterns.creational.abstractfactory.service.impl.CompanyProductFactory;
import com.design.patterns.creational.abstractfactory.service.impl.PersonalProductFactory;

public class FactoryProducer {


  public static FinancialProductAbstractFactory getFactory(String typeFactory) {
    if (CustomerType.PERSONAL.name().equals(typeFactory)) {
      return new PersonalProductFactory();
    } else if (CustomerType.COMPANY.name().equals(typeFactory)) {
      return new CompanyProductFactory();
    }
    return null;
  }
}
