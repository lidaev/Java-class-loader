import processor.ProcessedObject;

import java.io.File;
import java.util.Scanner;

public class InputProcessor implements Runnable{
    String fileName;
    ProcessedObject obj;

    public InputProcessor(String fileName, ProcessedObject obj) {
        this.fileName = fileName;
        this.obj = obj;
    }

    @Override
    public void run() {
        sum();
    }

    private void sum() {
        String fileElement = "";
        int fileInteger = 0;
        Scanner in = null;
        try {
            in = new Scanner(new File(fileName));
            while (in.hasNext()) {
                //check whether program should be terminated
                if (Main.ERROR == 1) {
                    System.out.println("Interrupting... ");
                    break;
                }
                fileElement = in.next();
                //check if the element is an integer
                try {
                    fileInteger = Integer.parseInt(fileElement);
                        obj.process(fileInteger);
                        System.out.println("Current sum value: " + obj.getValue());
                    //if not an integer, stop
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong input data. Finishing the program...");
                    Main.ERROR = 1;
                }
            }
        } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Finishing the program...");
                Main.ERROR = 1;
        } finally {
            in.close();
        }
    }
}
