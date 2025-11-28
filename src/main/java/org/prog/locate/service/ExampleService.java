package org.prog.locate.service;

import lombok.AllArgsConstructor;
import org.prog.locate.entity.Example;
import org.prog.locate.repository.ExampleRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExampleService {
  private final ExampleRepository exampleRepository;

  public Example getExampleById(Long id) {
    return exampleRepository.findById(id).orElse(null);
  }

  public Example saveExample(Example example) {
    return exampleRepository.save(example);
  }
}
