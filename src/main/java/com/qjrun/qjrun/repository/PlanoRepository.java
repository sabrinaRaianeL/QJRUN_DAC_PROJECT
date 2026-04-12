package com.qjrun.qjrun.repository;

import com.qjrun.qjrun.entity.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    List<Plano> findAllByAtivoTrue();
}
