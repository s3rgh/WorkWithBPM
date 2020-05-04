package org.sergh.app.interaction;

import org.sergh.app.execution.ExecutorCalls;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

public class SenderJsonService implements SenderJson {

    private ExecutorCalls executorCalls;

    public SenderJsonService() {
    }

    @Override
    public int postJson(String json) {

        int timeForRequest = 0;
        final String queryUrl = "https://6v5bk3r7iujya.s-quickbpm.ru/api/v1/app/enterCalls/calls/create";
        final String TOKEN = "eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJjb21wYW55IjoiNnY1YmszcjdpdWp5YSIsInVzZXJJZCI6IjhkN2NhNzQ2LTJlMjMtNDMyZS1iYWYwLWY4YzVkN2Y2ZjE1OCIsIm93bmVyIjp0cnVlLCJzZXNzaW9uSWQiOiJkNjc1ZjA3OS1hNDIxLTRiODktYmQ3OC0xZmI5NDA4OWQwZmYiLCJwcml2aWxlZ2VzIjpbInN5c3RlbSIsImFkbWluaXN0cmF0aW9uIiwic3VwZXJ2aXNvciJdLCJleHAiOjE1ODkyOTExODUsImlhdCI6MTU4ODA4MTQ2NSwiaXNzIjoiYXBpIn0.YenmMzAqbnqfW1WdA4gLTtR5D8Wn8iPX5hXsPXG-rzwyYA2o8vTAGjpLcesvuu47UyhUWk5h_kE_NByARAFCIWmTIPCyqCamGKnrhoELvhSqrkhRektxQSmu5m79Iw-ePmYc4N-EOeV1N-noIXdYalho6duwMZwseemMqxrVCvg";

        System.out.println(json);
        HttpsURLConnection connection;

        try {
            URL url = new URL(queryUrl);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Bearer " + TOKEN);
            Date d1 = new Date();
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(json.getBytes());
            System.out.println(connection.getResponseCode());
            outputStream.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result;
            StringBuilder builder = new StringBuilder();
            while ((result = in.readLine()) != null) {
                builder.append(result);
                builder.append("\n");
            }
            Date d2 = new Date();
            timeForRequest = (int) (d2.getTime() - d1.getTime());
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeForRequest;
    }
}