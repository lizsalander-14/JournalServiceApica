package com.user.service.impl;

import com.user.entity.Journal;
import com.user.model.UserJournalDTO;
import com.user.repository.JournalRepository;
import com.user.service.JournalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public void saveUserEventLog(UserJournalDTO userJournalDTO) {
        log.info("Got user event: {}", userJournalDTO);
        Journal journal = new Journal();
        BeanUtils.copyProperties(userJournalDTO, journal);
        journalRepository.save(journal);
    }

    @Override
    public List<Journal> getJournalsByEmail(String email) {
        return journalRepository.findByEmail(email);
    }
}
