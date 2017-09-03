package com.alessandra.respository;

import com.alessandra.entity.Pikmin;
import org.springframework.data.repository.CrudRepository;

public interface PikminRepository extends CrudRepository<Pikmin, Integer> {

    Pikmin findById(Integer id);

}
