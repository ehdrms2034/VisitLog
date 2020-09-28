package com.visitlog.visitlog.Repository;

import com.visitlog.visitlog.Model.Today;
import org.springframework.data.repository.CrudRepository;

public interface TodayRepository extends CrudRepository<Today,Long> {
}
