package hu.me.repository;

import hu.me.entity.CalculatorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculatorRepository extends CrudRepository<CalculatorEntity, Integer> {
    List<CalculatorEntity> findByOperations(String inputvalues);
}
