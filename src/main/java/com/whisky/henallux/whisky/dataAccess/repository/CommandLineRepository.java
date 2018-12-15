package com.whisky.henallux.whisky.dataAccess.repository;

import com.whisky.henallux.whisky.dataAccess.entity.CommandLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandLineRepository extends JpaRepository<CommandLineEntity,String> {
}
