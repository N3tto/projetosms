package com.pitang.projetosms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pitang.projetosms.models.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}