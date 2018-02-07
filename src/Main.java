import processor.ProcessInvHandler;
import processor.ProcessedObject;

import java.lang.reflect.Proxy;

public class Main {
    public static volatile int ERROR = 0;

    public static void main(String[] args) throws InterruptedException {
        //read urls
        String[] urls = {"input7.txt", "input8.txt"};

        //choose functionality
        ProcessedObject process =
                (ProcessedObject) Proxy.newProxyInstance(
                        ProcessedObject.class.getClassLoader(),
                        new Class[]{ProcessedObject.class},
                        new ProcessInvHandler()
                );

        //create and run threads

        for (int i = 0; i < urls.length; i++) {
           new Thread(new InputProcessor(urls[i], process)).start();
        }
    }
}

