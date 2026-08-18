package org.kaviya.riskmanagementsystem.service;

import org.kaviya.riskmanagementsystem.entity.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    Client getClientById(Long clientId);
}
