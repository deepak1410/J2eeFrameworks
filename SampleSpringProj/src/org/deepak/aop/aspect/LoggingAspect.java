package org.deepak.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.deepak.aop.model.Laptop;
import org.deepak.aop.model.Phone;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	// A complete advice declaration without any wildcard
	/*@Before("execution(public String org.deepak.aop.model.Laptop.getName())")
	public void beforeLogAdvice() {
		System.out.println("The getName() method has been called.");
	}*/
	
	/* Order of wildcard: visibility -> Return-Type -> package with className & method name -> Parameters
	In parameters of methods giving * means there would be at least one argument while giving .. means 
	there might be any number of arguments */
	@Pointcut("execution(* *.get*(..))")
	public void allGetters(){}
	
	@Pointcut("execution(* org.deepak.aop.model.Phone.get*(..))")
	public void allPhoneGetterMethods(){}
	
	//within takes parameter as class while execution takes parameter as method.
	@Pointcut("within(org.deepak.aop.model.Phone)")
	public void allPhoneMethods(){}
	
	// * is required for every package name
	@Pointcut("within(org.*.aop.*.*)")
	public void allMethodsUsingWithin(){}
	
	@Pointcut("args(String, ..)")
	public void allMethodsUsingArgs(){}
	
	//JoinPoint is used to get the information about methods where the cross cutting concerns are applied.
	@Before("within(org.*.aop.*.*) && args(String, ..) && allPhoneGetterMethods() || allMethodsUsingArgs()")
	public void beforeLogAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getKind() + " Method has been called using PointCut.");
	}
	
	// We can pass a parameter in the args and can print that.
	@Before("args(name)")
	public void beforeLogTestAdvice(String name){
		String arg = name;
		System.out.println("Just Testing.." + name);
	}
	
	// One of the most useFul JoinPoint API is getTarget(). Using this one can manipulate the parameters passed to a method dynamically.
	@Before("within(org.*.aop.*.*) || allPhoneGetterMethods() || allMethodsUsingArgs()")
	public void beforeExecAdvice(JoinPoint joinPoint) {
		
		Object obj = joinPoint.getTarget();
		if(obj instanceof Phone) {
			((Phone) obj).setName("Galaxy Note 4");
		}
		
		if(obj instanceof Laptop) {
			((Laptop) obj).setName("MacBook");
		}

		System.out.println(joinPoint.getTarget().toString() + " calling method using PointCut.");
	}
	
	// There are 3 types of after advices: @After, @AfterAdvice and @AfterReturning. @After advice is kind of after-finally which always executes.
		@After("allPhoneGetterMethods()")
		public void afterLogTestAdvice(JoinPoint joinPoint){
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println("AfterAdvice is executed after executing method: " + methodName);
		}
		
	// Printing the value that a method is returning after execution. The type of returning object has been made Object so it is applied for all method
	// This can be changed to specific datatype to apply for specific methods.
	@AfterReturning(pointcut="execution(* *.*(..))",returning="returnVal")
	public void displayReturnVal(Object returnVal) {
		System.out.println("The method is returning: " + returnVal);
	}
	
	// Catching exception and printing. For testing uncomment the throw exception line from getName and comment out the return.
	@AfterThrowing(pointcut="execution(* *.*(..))",throwing="ex")
	public void logExceptionAdvice(Exception ex) {
		System.out.println("The method has thrown exception: ");
		ex.printStackTrace();
	}
	
	// Two things are mandatory in Around advice (1) Having a parameter of type ProceedingJoinPoint and calling proceed() method on it.
	// Around advice can perform everything what all advice do but it's advisable to use least powerful advice if we don't need require extra features. 
	@Around("allPhoneMethods()")
	public void logAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			System.out.println("Before method exceution...");
			proceedingJoinPoint.proceed();
			System.out.println("After method returning...");
		} catch (Throwable e) {
			System.out.println("After exception occurred...");
			e.printStackTrace();
			System.out.println("After executing finally...");
		}
	}
	
	@Around("allPhoneMethods()")
	public void logCustomAnnotationAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			System.out.println("Before method exceution...applied only for methods having Loggable annotation...");
			proceedingJoinPoint.proceed();
			System.out.println("After method returning...applied only for methods having Loggable annotation...");
		} catch (Throwable e) {
			System.out.println("After exception occurred...applied only for methods having Loggable annotation...");
			e.printStackTrace();
			System.out.println("After executing finally...applied only for methods having Loggable annotation...");
		}
	}


}
