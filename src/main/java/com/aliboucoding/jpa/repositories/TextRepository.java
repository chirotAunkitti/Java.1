package com.aliboucoding.jpa.repositories;

import com.aliboucoding.jpa.mosels.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends JpaRepository<Text, Long> {
}
