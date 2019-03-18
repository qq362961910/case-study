package com.jy.util.casestudy.common.jdk11;

//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.time.Duration;

public class HttpClientUsage {

    /*public static void main(String[] args) throws Exception {
        synchronizedRequest();
        asynchronousRequest();
    }

    public static void synchronizedRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://www.baidu.com"))
            .build();
        HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(2))
            .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
            .authenticator(Authenticator.getDefault())
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

    public static void asynchronousRequest() {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://www.baidu.com"))
            .timeout(Duration.ofMinutes(2))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("request-payload.json")))
            .POST(HttpRequest.BodyPublishers.ofString("{a: 1}"))
            .build();

        HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(2000))
            .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
            .authenticator(Authenticator.getDefault())
            .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println);
    }*/

}
