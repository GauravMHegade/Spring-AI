package com.demo.SpringAI.config;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatModelConfig {

    @Bean("simpleChatClient")
    public ChatClient simpleChatClient(ChatModel chatModel){
        return ChatClient.builder(chatModel)
                .defaultSystem("You are an HR assistant")
                .defaultOptions(
                        OllamaChatOptions.builder()
                                .temperature(0.7)
                                .model("llama3.2:1b")
                )
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }

    @Bean("advancedChatClient")
    public ChatClient advancedChatClient(ChatModel chatModel){
        return ChatClient.builder(chatModel)
                .defaultOptions(
                        OllamaChatOptions.builder()
                                .model("llama3.2:3b")
                ).build();
    }
}
