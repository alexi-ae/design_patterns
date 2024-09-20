package com.design.patterns.structural.proxy.utils;

import java.util.Random;

public final class Constants {

  static Random random = new Random();

  public static double generateAmount() {
    return 10 + (1400 - 10) * random.nextDouble();
  }

  private Constants() {
  }
}
