package com.aliboucoding.jpa.repositories;

import com.aliboucoding.jpa.mosels.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // สามารถเพิ่มเมธอดเพิ่มเติมได้ตามความต้องการ
}
