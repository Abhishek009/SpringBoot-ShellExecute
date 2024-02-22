package com.api.repository;

import com.api.model.FileInfo;
import com.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository  extends JpaRepository<FileInfo, Long> {


}

