package com.aliboucoding.jpa.repositories;

import com.aliboucoding.jpa.mosels.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    // คุณสามารถเพิ่มเมธอดเพิ่มเติมที่จำเป็นตามความต้องการได้
}
