package com.demo.SpringAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

//    private final ChatClient chatClient;

    private final ChatClient simpleChatClient;
    private final ChatClient advancedChatClient;


//    public ChatController(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.build();
//    }


    public ChatController(@Qualifier("simpleChatClient") ChatClient simpleChatClient, @Qualifier("advancedChatClient")ChatClient advancedChatClient) {
        this.simpleChatClient = simpleChatClient;
        this.advancedChatClient = advancedChatClient;
    }


//    @GetMapping
//    public String chat(@RequestParam("message") String message){
//        return this.chatClient.prompt(message)
//                                .call()
//                                .content();
//    }


    @GetMapping("/simple")
    public String simpleChat(@RequestParam String message){
        return simpleChatClient.prompt(message)
                .call()
                .content();
    }

    @GetMapping("/advanced")
    public String advancedChat(@RequestParam String message){
        return advancedChatClient.prompt(message)
                .call()
                .content();
    }

}
