package com.bmstu.WGServer.repo;

import com.bmstu.WGServer.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
