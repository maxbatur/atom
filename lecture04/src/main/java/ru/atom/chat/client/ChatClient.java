package ru.atom.chat.client;

import okhttp3.*;


import java.io.IOException;
import java.net.URL;


public class ChatClient {
    private static final OkHttpClient client = new OkHttpClient();
    private static final String PROTOCOL = "http://";
    private static final String HTTP_SCHEME = "http";
    private static final String HOST = "localhost";
    private static final String PORT = ":8080";
    private static final Integer HTTP_PORT = 8080;

    //POST host:port/chat/login?name=my_name
    public static Response login(String name) throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        Request request = new Request.Builder()
                .post(RequestBody.create(mediaType, ""))
                .url(PROTOCOL + HOST + PORT + "/chat/login?name=" + name)
                .build();
        return client.newCall(request).execute();
    }


    //GET host:port/chat/online
    public static Response viewOnline() throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(HTTP_SCHEME)
                .host(HOST)
                .port(HTTP_PORT)
                .addPathSegment("chat")
                .addPathSegment("online")
                .build();
        Request request = new Request.Builder()
                .get()
                .url(httpUrl)
                .build();
        return client.newCall(request).execute();
    }


    //POST host:port/chat/say?name=my_name
    //Body: "msg='my_message'"
    public static Response say(String name, String msg) throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(HTTP_SCHEME)
                .host(HOST)
                .port(HTTP_PORT)
                .addPathSegment("chat")
                .addPathSegment("say")
                .addQueryParameter("name", name)
                .addQueryParameter("msg", msg)
                .build();
        Request request = new Request.Builder()
                .post(RequestBody.create(mediaType, ""))
                .url(httpUrl)
                .build();
        return client.newCall(request).execute();
    }


    //GET host:port/chat/chat
    public static Response viewChat() throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(HTTP_SCHEME)
                .host(HOST)
                .port(HTTP_PORT)
                .addPathSegment("chat")
                .addPathSegment("chat")
                .build();
        Request request = new Request.Builder()
                .get()
                .url(httpUrl)
                .build();
        return client.newCall(request).execute();
    }

    //POST host:port/chat/logout?name=my_name
    public static Response logout(String name) throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(HTTP_SCHEME)
                .host(HOST)
                .port(HTTP_PORT)
                .addPathSegment("chat")
                .addPathSegment("logout")
                .addQueryParameter("name", name)
                .build();
        Request request = new Request.Builder()
                .post(RequestBody.create(mediaType, ""))
                .url(httpUrl)
                .build();
        return client.newCall(request).execute();
    }
}