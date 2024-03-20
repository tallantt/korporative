
package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Logger;
import org.example.repository.LoggerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggerService {
    public final LoggerRepository repository;
    public Logger Log(Logger log){
        return repository.save(log);
    }
}
