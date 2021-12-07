package com.hcl.emobileconnect.dao;

import com.hcl.emobileconnect.entity.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request, Integer> {} //TODO