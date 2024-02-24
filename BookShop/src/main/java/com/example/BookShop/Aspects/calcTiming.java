package com.example.BookShop.Aspects;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class calcTiming {

    Logger log= LoggerFactory.getLogger(calcTiming.class);
     /*
     * here we want to calc the time for every service we will use in the program in log file
     * */
//    @Around(value = "execution(* com.example.BookShop.Services..*(..))")
//    public Object Calctime(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        Long StartTime=System.currentTimeMillis();
//       StringBuilder sb=new StringBuilder("kpi:");
//      sb.append("[").append(joinPoint.getKind()).append("]\tfor").append(joinPoint.getSignature())
//              .append(" \twithArgs").append("(").append(StringUtils.join(joinPoint.getArgs(),",")).append(")");
//      sb.append("\ttook: ");
//      Object value=joinPoint.proceed();
//      log.info(sb.append(System.currentTimeMillis()-StartTime) .append("ms.").toString());
//      return value;
//    }

    /*
    * we can use pointcut for more specification forevery package i want
    * to check in the project so we have a pointcut with its expressions for that
    *
    */
    @Pointcut("execution(* com.example.BookShop.Controller.*(..))")
    public void LogForController(){}
    @Pointcut("execution(* com.example.BookShop.Services.*(..))")
    public void LogForService(){}
    @Pointcut("execution(* com.example.BookShop.Repos.*(..))")
    public void LogForRepos(){}
    @Pointcut("LogForController() || LogForService() || LogForRepos()")
    public void ForAllPoints(JoinPoint joinPoint){
        String MethodName= joinPoint.getSignature().getName().toString();
        log.info("the Method Name is >>>>>- ", MethodName);

        // we will loop for every arg to show it in the log file
         Object[] args=joinPoint.getArgs();
         for(Object arg:args){
           log.info("the Method args are >>>>",arg);
         }

    }





}
