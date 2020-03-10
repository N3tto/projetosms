package com.pitang.projetosms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pitang.projetosms.models.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer>{

}
