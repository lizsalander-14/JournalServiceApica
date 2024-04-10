package com.user.controller;

import com.user.entity.Journal;
import com.user.service.JournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/journal")
@Slf4j
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping("/{email}")
    public ResponseEntity<List<Journal>> getJournalsByEmail(@PathVariable("email")String email){
        log.info("Going to get user journals for email: {}", email);
        return new ResponseEntity<>(journalService.getJournalsByEmail(email), HttpStatus.OK);
    }
}
