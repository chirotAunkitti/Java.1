package com.aliboucoding.jpa.repositories;

import com.aliboucoding.jpa.mosels.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
