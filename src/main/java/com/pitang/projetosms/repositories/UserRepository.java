package com.pitang.projetosms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pitang.projetosms.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

}
