package com.example.filezone.repository;

import com.example.filezone.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {}
