
package org.example.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.entity.Logger;
import org.example.service.LoggerService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class MyLog {

    private final LoggerService loggerService;
    @Around(value ="@annotation(org.example.aspect.ToLog)")
    public Object myLogMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Aspect working");
        Object logger = joinPoint.proceed();

        String request = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));

        Logger newLog = new org.example.entity.Logger (null,request,logger.toString(),
                LocalDateTime.now());

        loggerService.Log(newLog);

        log.info("in->{}, out->{}",request,logger);
        return logger;
    }
}
