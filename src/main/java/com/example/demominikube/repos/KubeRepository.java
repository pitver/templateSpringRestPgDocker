package com.example.demominikube.repos;

import com.example.demominikube.model.Kube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * KubeRepository
 *
 * @author Вершинин Пётр
 */
@Repository
public interface KubeRepository extends JpaRepository<Kube,Long> {

}
