package com.example.truecaller.domain;

import com.example.truecaller.domain.enums.UserCategory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class User {
    private String id;
    private String name;
    private String phoneNumber;
    private LocalDateTime lastAccessed;
    private UserCategory userCategory;
    private List<String> blockedContacts;
    private Set<String> blockedSet;
    private List<Contact> contacts;
}
