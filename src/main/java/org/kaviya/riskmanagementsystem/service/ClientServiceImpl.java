package org.kaviya.riskmanagementsystem.service;

import org.kaviya.riskmanagementsystem.entity.Client;
import org.kaviya.riskmanagementsystem.exception.ClientNotFoundException;
import org.kaviya.riskmanagementsystem.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() ->
                        new ClientNotFoundException("Client not found with id: " + clientId));
    }
}
