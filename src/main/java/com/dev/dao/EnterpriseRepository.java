package com.dev.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dev.entities.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise,Long>
{
	
	@Query("select e from Enterprise e where e.name like :x ")
	Page<Enterprise> searchByName(@Param("x") String e,Pageable pageable);

}
