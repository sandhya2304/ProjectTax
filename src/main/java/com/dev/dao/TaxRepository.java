package com.dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.entities.Enterprise;
import com.dev.entities.Tax;

public interface TaxRepository extends JpaRepository<Tax,Long>
{

}
