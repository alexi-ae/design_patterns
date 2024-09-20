package com.design.patterns.structural.facade.service;

public class NotificationService {

  public void send(String email, String message) {
    System.out.println("Notificación enviada a " + email + ": " + message);
  }
}
