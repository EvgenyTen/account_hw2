package ru.iteco.account.homeworkOne;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class CacheResultMethodInterceptor implements MethodInterceptor {
    public static final Map <String,Map<MethodArgs, Object>> CACHE = new ConcurrentHashMap<>();

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable{
        final Method method =invocation.getMethod();
        boolean isAnnotationMethod = method.isAnnotationPresent(CacheResult.class);
        if(!isAnnotationMethod){
            for (Method declaredMethod : invocation.getThis().getClass().getDeclaredMethods() ) {
                if(method.getName().equals(declaredMethod.getName()) &&
                        AnnotationUtils.findAnnotation(declaredMethod,CacheResult.class)!= null){
                    isAnnotationMethod =true;
                    break;
                }
            }
        }

        }
    }
}
