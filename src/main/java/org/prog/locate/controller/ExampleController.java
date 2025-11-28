package org.prog.locate.controller;

import lombok.AllArgsConstructor;
import org.prog.locate.entity.Example;
import org.prog.locate.service.ExampleService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ExampleController {
  private final ExampleService exampleService;

  @GetMapping("/{id}")
  public Example getExampleById(@PathVariable Long id) {
    return exampleService.getExampleById(id);
  }

  @PostMapping
  public Example saveExample(@RequestBody Example example) {
    return exampleService.saveExample(example);
  }
}
