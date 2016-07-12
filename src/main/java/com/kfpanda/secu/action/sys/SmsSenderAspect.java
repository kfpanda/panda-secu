package com.kfpanda.secu.action.sys;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 拦截短信发送接口，不执行短信发送。提供测试使用。
 * @author kfpanda
 * @date 2016/6/16
 */
@Component
@Aspect
public class SmsSenderAspect {
    private final static Logger logger = LoggerFactory.getLogger(SmsSenderAspect.class);

    @Value("${run.mode:}")
    private String runMode;
    private String TEST_MODE = "test";
    private static Map<String, String> channelMap = new HashMap<>();
    static {
        channelMap.put("BWSmsSenderImpl", "百悟");
        channelMap.put("MDSmsSenderImpl", "漫道");
        channelMap.put("MWSmsSenderImpl", "梦网");
        channelMap.put("XWSmsSenderImpl", "玄武");
        channelMap.put("YMSmsSenderImpl", "亿美");
    }

    @Pointcut("execution(* com.kfpanda.secu.action.sys..pageFind(..))")
    public void action() {
        System.out.println("+++++++++++++++++++++++++");
    }

    @Pointcut("execution(* com.kfpanda.secu.service.sys..pageFind(..))")
    public void service() {
        System.out.println("+++++++++++++++++++++++++");
    }

    @Around("service()")
    public Object service(ProceedingJoinPoint call) throws Throwable {
        System.out.println("+++++++44444++++++++++++++++++");
        return call.proceed();
    }

    @Around("action()")
    public Object action(ProceedingJoinPoint call) throws Throwable {
        System.out.println("+++++++555555555555555++++++++++++++++++");
        return call.proceed();
    }
}
