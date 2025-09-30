package com.levelVini.DockerPersistenceTest.repository;

import com.levelVini.DockerPersistenceTest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
