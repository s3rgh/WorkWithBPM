package org.sergh.app.execution;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.sergh.app.entity.Call;
import org.sergh.app.entity.Phone;
import org.sergh.app.interaction.SenderJsonService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorCallsService implements ExecutorCalls {

    private SenderJsonService senderJsonService = new SenderJsonService();

    private static Call createCall(int n) {

        Call call = new Call();
        Phone phone = new Phone();
        call.set__name("Call_name_number#" + n);
        call.setCompanyName("CompanyName#" + n);
        call.setFirstName("customerName#" + n);
        call.setLastName("customerSurName#" + n);
        call.setPhone(phone.setRandomPhone(), phone.setType());
        call.setTestMessage(call.generateSimpleString());
        call.setDate();
        System.out.println(call.toString());
        return call;
    }

    @Override
    public void simpleExecutor() {
        int n = 0;
        BufferedReader bufferedReader;
        Call call = new Call();

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name of call");
            call.set__name(bufferedReader.readLine());
            System.out.println("Enter companyName");
            call.setCompanyName(bufferedReader.readLine());
            System.out.println("Enter firstName");
            call.setFirstName(bufferedReader.readLine());
            System.out.println("Enter lastName");
            call.setLastName(bufferedReader.readLine());
            System.out.println("Enter phone number and type");
            call.setPhone(bufferedReader.readLine(), bufferedReader.readLine());
            System.out.println("Enter message of call");
            call.setTestMessage(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        n = senderJsonService.postJson(ObjToJson(call));
    }

    @Override
    public void parallelExecutor() {

        System.out.println("Enter number of calls:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        List<Call> listOfCalls = IntStream.range(0, number).mapToObj(ExecutorCallsService::createCall).collect(Collectors.toList());

        List<Future<Integer>> futures;

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        futures = listOfCalls.stream().map(call -> executorService.submit(() -> senderJsonService.postJson(ObjToJson(call)))).collect(Collectors.toList());

        List<Integer> listOfTimesForRequest = futures.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());

        listOfTimesForRequest.stream().map(i -> i + " ").forEach(System.out::println);
    }

    @Override
    public String ObjToJson(Call call) {
        final Gson GSON = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        String str = GSON.toJson(call);
        return ("{\"context\":" + str + "}");
    }
}
