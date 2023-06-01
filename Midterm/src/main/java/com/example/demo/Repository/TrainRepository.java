package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.*;


@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {
	List<Train> findBySourceAndDestination(String source, String destination);

}
