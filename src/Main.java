import processor.ProcessInvHandler;
import processor.ProcessedObject;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class Main {
    public static volatile int ERROR = 0;

    public static void main(String[] args) throws InterruptedException {
        //read urls
        ArrayList<String> urls = new ArrayList();
        urls.add("input7.txt");
        urls.add("input8.txt");

        //choose functionality
        ProcessedObject process =
                (ProcessedObject) Proxy.newProxyInstance(
                        ProcessedObject.class.getClassLoader(),
                        new Class[]{ProcessedObject.class},
                        new ProcessInvHandler()
                );

        //create and run threads
        urls.forEach(url -> new Thread(new InputProcessor(url, process)).start());
    }
}

