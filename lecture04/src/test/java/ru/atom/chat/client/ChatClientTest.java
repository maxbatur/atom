package ru.atom.chat.client;

import okhttp3.Response;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.atom.chat.client.ChatClient;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChatClientTest {
    private static String MY_NAME_IN_CHAT = "admin";
    private static String MY_MESSAGE_TO_CHAT = "Hello chatters!";

    @Test
    public void test1_login() throws IOException {
        Response response = ChatClient.login(MY_NAME_IN_CHAT);
        System.out.println("[" + response + "]");
        String body = response.body().string();
        System.out.println(body);
        Assert.assertTrue(response.code() == 200 || body.equals("Already logged in:("));
    }

    @Test
    public void test2_viewOnline() throws IOException {
        Response response = ChatClient.viewOnline();
        System.out.println("[" + response + "]");
        System.out.println(response.body().string());
        Assert.assertEquals(200, response.code());
    }

    @Test
    public void test3_say() throws IOException {
        Response response = ChatClient.say(MY_NAME_IN_CHAT, MY_MESSAGE_TO_CHAT);
        System.out.println("[" + response + "]");
        System.out.println(response.body().string());
        Assert.assertEquals(200, response.code());
    }

    @Test
    public void test4_viewChat() throws IOException {
        Response response = ChatClient.viewChat();
        System.out.println("[" + response + "]");
        System.out.println(response.body().string());
        Assert.assertEquals(200, response.code());
    }

    @Test
    public void test5_logout() throws IOException {
        Response response = ChatClient.logout(MY_NAME_IN_CHAT);
        System.out.println("[" + response + "]");
        String body = response.body().string();
        System.out.println(body);
        Assert.assertTrue(response.code() == 200 || body.equals("No such user here :("));
    }



}
