package cinos.backend.dao;

import cinos.backend.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeveloperDAO  extends JpaRepository<Developer, Long> {

    @Query(value = "select * from developer where private_key= :key", nativeQuery = true)
    Developer findDeveloperByKey(@Param("key") String key);
}
