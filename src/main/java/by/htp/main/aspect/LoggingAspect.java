package by.htp.main.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @Before("execution(* by.htp.main.service.CustomerServiceImpl.getCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    /*@Around("execution(* by.htp.main.service.NewsServiceImpl.getNews(..))")
    public void logAround(JoinPoint joinPoint) {

        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        //System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        //joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after is running!");

        System.out.println("******");
    }*/
}
