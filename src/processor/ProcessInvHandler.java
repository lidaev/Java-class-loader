package processor;

import loader.MyLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProcessInvHandler implements InvocationHandler {
    MyLoader myLoader = new MyLoader();
    Object processor;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

       if (processor == null) {
           processor = myLoader
                   .loadClass("NegativeIntegersAdder") //ability to change to integers adder class
                   .newInstance();
       }

        return method.invoke(processor, args);
    }
}
