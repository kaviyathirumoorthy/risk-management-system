package org.kaviya.riskmanagementsystem.repository;

import org.kaviya.riskmanagementsystem.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}