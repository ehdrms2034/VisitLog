package com.visitlog.visitlog.Repository;

import com.visitlog.visitlog.Model.Badge;
import org.springframework.data.repository.CrudRepository;

public interface SvgRepository extends CrudRepository<Badge,Long> {

}