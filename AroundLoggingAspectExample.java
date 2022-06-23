@Component
@Aspect
@Log4j2
public class LoggingAspectExample {

    @Around("execution(* com.example.*.*(..))")
    public Object loggingAspect(ProceedingJoinPoint joinPoint) throws Throwable {

        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        try {
            return joinPoint.proceed(); //IMP dont forget to add this return statement -> else your aspect will not work as expected.
        } finally {
            stopWatch.stop();
            log.info(Execution Time is " + stopWatch.getLastTaskTimeMillis() + " ms");
        }
    }
}
