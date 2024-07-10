package com.aliboucoding.jpa.repositories;

import com.aliboucoding.jpa.mosels.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
}
