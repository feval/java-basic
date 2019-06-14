package com.executor;

import java.util.concurrent.*;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/13 19:52
 */
class CallableTest implements Callable<String> {
    private int ticket=20;
    @Override
    public String call() {
        for (int i = 0; i <20 ; i++) {
            while (ticket>0) {
                System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
            }
            return Thread.currentThread().getName()+"票卖完了";
        }
        return null;
    }
}

public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        ExecutorService executorService=new ThreadPoolExecutor(2,3,60,TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        CallableTest callableTest=new CallableTest();
        Future<String> submit = null;
        for (int i = 0; i <5 ; i++) {
            submit = executorService.submit(callableTest);
        }
        System.out.println(submit.get());
        executorService.shutdown();*/
//        System.out.println(Runtime.getRuntime().availableProcessors());
/*        ExecutorService executorService1=Executors.newCachedThreadPool();
        for (int i = 0; i <5 ; i++) {
            Thread.sleep(10);
            executorService1.submit(new CallableTest());
        }
        executorService1.shutdown();*/
        ScheduledExecutorService executorService3=Executors.newScheduledThreadPool(3);
        for (int i = 0; i <5 ; i++) {
            executorService3.schedule(new CallableTest(),2,TimeUnit.SECONDS);
            executorService3.shutdown();
        }
    }
}
