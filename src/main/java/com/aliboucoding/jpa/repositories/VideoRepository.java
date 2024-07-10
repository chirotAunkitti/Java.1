package com.aliboucoding.jpa.repositories;

import com.aliboucoding.jpa.mosels.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
