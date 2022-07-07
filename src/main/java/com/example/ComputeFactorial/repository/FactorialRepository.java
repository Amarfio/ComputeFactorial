package com.example.ComputeFactorial.repository;

import com.example.ComputeFactorial.model.Factorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactorialRepository extends JpaRepository<Factorial, Long> {
}
