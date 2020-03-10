package com.pitang.projetosms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pitang.projetosms.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}
