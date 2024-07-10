package com.aliboucoding.jpa.repositories;

import com.aliboucoding.jpa.mosels.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
