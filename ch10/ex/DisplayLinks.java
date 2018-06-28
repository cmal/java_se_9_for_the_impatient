package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.regex.*;
import java.net.*;
import jdk.incubator.http.*;

public class DisplayLinks {
    
    // 25. Write a program that asks the user for a URL, reads the web
    // page at that URL, and displays all the links. Use a
    // CompletableFuture for each step. Don’t call get.

    public static void main(String[] args) {
        try {
            System.out.print("give me an URL: ");
            Scanner in = new Scanner(System.in);
            String inStr = in.nextLine();
            in.close();
            URI uri = new URI(inStr);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            CompletableFuture<HttpResponse<String>> f = client.sendAsync(request, HttpResponse.BodyHandler.asString());

            // CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> {
            //         String result;
            //         Compute the result;
            //         return result;
            //     }, executor);

            f.join();

            f.whenComplete((s, t) -> {
                    if (t == null) {
                        String HTMLPage = s.body();
                        Pattern linkPattern = Pattern.compile("(<a[^>]+>.+?<\\/a>)",  Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
                        Matcher m = linkPattern.matcher(HTMLPage);
                        // ArrayList<String> links = new ArrayList<String>();
                        while(m.find()){
                            // links.add(m.group());
                            System.out.println(m.group());
                        }
                    } else {
                        t.printStackTrace();
                    }
                });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}


