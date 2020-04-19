//package com.lp.annotation;
//
//import com.lp.entity.SystemLog;
//import com.lp.entity.User;
//import com.lp.service.LogServiceInterface;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.lang.reflect.Method;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Aspect
//@Component
//public class LogAopAspect {
//
//    @Autowired
//    private LogServiceInterface logService;
//
//    /**
//     * 声明切点，使用了注解@Anno的方法会被拦截
//     * */
//    @Pointcut("@annotation(com.lp.annotation.Anno)")
//    public void controllerAspect(){
//    }
//
//    /**
//     * 方法返回后执行,
//     * */
//
//    @AfterReturning(pointcut = "controllerAspect()")
//    public void AfterReturning(JoinPoint joinPoint){
//
//        // 保存数据库
////        logService.saveByJoinPoint(joinPoint,null);
//        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//        String ip = request.getRemoteAddr();
//        String targerName = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
//        Date date=new Date();
//        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String targetName = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] arguments = joinPoint.getArgs();
//        Class targetClass = null;
//        try {
//            targetClass = Class.forName(targetName);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Method[] methods = targetClass.getMethods();
//        String operationType = "";
//        String operationName = "";
//        for (Method method : methods) {
//            if (method.getName().equals(methodName)) {
//                Class[] clazzs = method.getParameterTypes();
//                if (clazzs.length == arguments.length) {
//                    operationType = method.getAnnotation(Anno.class).operationType();
//                    operationName = method.getAnnotation(Anno.class).operationName();
//                    break;
//                }
//            }
//        }
//
//        SystemLog systemLog = new SystemLog();
//        if (user !=null) {
//            String RequestUserName = user.getUsername();
//            System.out.println("请求人：" + RequestUserName);
//            systemLog.setCreateBy(RequestUserName);
//        }
//        systemLog.setRequestIp(ip);
//        systemLog.setCreateDate(formatter.format(date));
//        systemLog.setDescription(operationType + operationName);
//        logService.addLog(systemLog);
//        System.out.println("操作方法：" + operationType + operationName);
//        System.out.println("ip地址为: "+ ip);
//        System.out.println("请求方法：" + targerName);
//
//    }
//
//}
