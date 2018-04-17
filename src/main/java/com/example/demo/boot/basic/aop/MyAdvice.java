package com.example.demo.boot.basic.aop;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {
	
	@Before("execution(* com.example.demo.springbasic.service.*.before*(..))")
	public void permissionCheck() {
		System.out.println("模拟权限检查");
	}
	
	@AfterReturning(returning="returnValue", pointcut="execution(* com.example.demo.springbasic.service.*.afterReturning*(..))")
	public void log(Object returnValue) {
		System.out.println("目标方法返回值：" + returnValue);
        System.out.println("模拟日志记录功能...");
	}
	
	@AfterThrowing(throwing="ex",pointcut="execution(* com.example.demo.springbasic.service.*.before*(..))")
    public void handleException(Throwable ex) {
        System.out.println("目标方法抛出异常：" + ex);
        System.out.println("模拟异常处理");
    }
	
	@After(value="execution(* com.example.demo.springbasic.service.*.afterAdvice*(..))")
    public void releaseResource() {
        System.out.println("模拟释放数据库连接");
    }
	
	@Around(value="execution(* com.example.demo.springbasic.service.*.around*(..))")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("模拟执行目标方法前的增强处理：事务开始...");
        //修改目标方法的参数
        Object[] params = new Object[]{"param1", 2, "param3"};
        System.out.println("拦截的方法： " + point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("参数： " + Arrays.toString(point.getArgs()));
        //执行目标方法，并保存目标方法执行后的返回值
        Object returnValue = point.proceed(params);
        System.out.println("模拟执行目标方法后的增强处理：事务结束...");
        //返回修改后的返回值
        return "方法实际返回值：" + returnValue + "，这是返回值的后缀";
    }
	
	@AfterReturning(
            pointcut="execution(* com.example.demo.springbasic.service.*.access*(..)) && args(time, name)",
            returning="returnValue")
    public void access(Date time, Object returnValue, String name) {
        System.out.println("目标方法中的参数String = " + name);
        System.out.println("目标方法中的参数Date = " + time);
        System.out.println("目标方法的返回结果returnValue = " + returnValue);
    }
}
