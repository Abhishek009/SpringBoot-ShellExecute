package com.api.repository;

import com.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceCountryRepository  extends JpaRepository<User, Long> {


}
