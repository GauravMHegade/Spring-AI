package com.demo.SpringAI.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.prompt.Prompt;
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

    public ChatController(@Qualifier("simpleChatClient") ChatClient simpleChatClient, @Qualifier("advancedChatClient")ChatClient advancedChatClient) {
        this.simpleChatClient = simpleChatClient;
        this.advancedChatClient = advancedChatClient;
    }

//    public ChatController(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.build();
//    }





    /*
    * Single Chat Model
    * */

//    @GetMapping
//    public String chat(@RequestParam("message") String message){
//        return this.chatClient.prompt(message)
//                                .call()
//                                .content();
//    }




    /*
    * Multiple Chat Models
    * */


//    @GetMapping("/simple")
//    public String simpleChat(String message){
//        return simpleChatClient.prompt(message)
//                .call()
//                .content();
//    }
//
//    @GetMapping("/advanced")
//    public String advancedChat(String message){
//        return advancedChatClient.prompt(message)
//                .call()
//                .content();
//    }






    /*
    *
    * Message Roles
    * */



//    @GetMapping("/simple")
//    public String simpleChat(String message){
//        return simpleChatClient.prompt()
//                .system("You are a Java Backend Developer Trainer. Explain in Simple English") // instead of writing this everywhere we can use defaults while creating chatModel. Default are used to set Default Behaviour
//                .user(message)
//                .call()
//                .content();
//    }
//
//    @GetMapping("/advanced")
//    public String advancedChat(String message){
//        return advancedChatClient.prompt()
//                .system("You are a Java Backend Developer Trainer. Explain in Simple English")
//                .user(message)
//                .call()
//                .content();
//    }




    /*
    *
    * Defaults
    * 
    * */

    @GetMapping("/simple")
    public String simpleChat(String message){
        return simpleChatClient.prompt()
                // we don't need to write this behaviour in every request, because we are using Defaults
//                .system("You are a Java Backend Developer Trainer. Explain in Simple English") // instead of writing this everywhere we can use defaults while creating chatModel. Default are used to set Default Behaviour
                .user(message)
                .call()
                .content();
    }

    @GetMapping("/advanced")
    public String advancedChat(String message){
        return advancedChatClient.prompt()
//                .system("You are a Java Backend Developer Trainer. Explain in Simple English")
                .user(message)
                .call()
                .content();
    }

}
