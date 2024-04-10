package com.user.service;

import com.user.entity.Journal;
import com.user.model.UserJournalDTO;

import java.util.List;

public interface JournalService {

    void saveUserEventLog(UserJournalDTO userJournalDTO);

    List<Journal> getJournalsByEmail(String email);
}
