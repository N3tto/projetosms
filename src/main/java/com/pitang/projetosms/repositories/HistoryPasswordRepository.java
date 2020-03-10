package com.pitang.projetosms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pitang.projetosms.models.HistoryPassword;

@Repository
public interface HistoryPasswordRepository extends JpaRepository<HistoryPassword, Integer>{

}
