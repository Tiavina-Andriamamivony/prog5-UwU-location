package org.prog.locate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.prog.locate", "org.prog.locate.controller"})
public class LocateApplication {

  public static void main(String[] args) {
    SpringApplication.run(LocateApplication.class, args);
  }
}
