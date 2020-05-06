package org.sergh.app;

import org.sergh.app.execution.ExecutorCallsService;

public class Main {
    public static void main(String[] args) {

        new ExecutorCallsService().parallelExecutor();

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter \"1\", if you want manually create call or - \"2\" if you want to start autocreating 1000 records.");
            System.out.println("Enter \"exit\" for close program.");
            String string = bufferedReader.readLine();
            switch (string) {
                case "1":
                    System.out.println();
                    new ExecutorCallsService().simpleExecutor();

                    break;
                case "2":
                    new ExecutorCallsService().parallelExecutor();

                    break;
                case "exit":
                    break;
                default:
                    System.out.println();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
