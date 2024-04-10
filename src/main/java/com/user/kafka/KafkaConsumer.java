package com.user.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.model.UserJournalDTO;
import com.user.service.JournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    private JournalService journalService;

    @KafkaListener(topics = "${kafka.topic.user.events}")
    public void consume(String payload) {
        log.info("Received user event: {}", payload);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            UserJournalDTO dto=objectMapper.readValue(payload, UserJournalDTO.class);
            journalService.saveUserEventLog(dto);
        } catch (JsonProcessingException e) {
            log.error("Error reading payload: {}", payload);
        }
    }

}
