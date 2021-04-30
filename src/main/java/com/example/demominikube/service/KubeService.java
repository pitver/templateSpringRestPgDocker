package com.example.demominikube.service;

import com.example.demominikube.model.Kube;
import com.example.demominikube.repos.KubeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * KubeService
 *
 * @author Вершинин Пётр
 */
@Service
public class KubeService {

    private final KubeRepository kubeRepository;

    public KubeService(KubeRepository kubeRepository) {
        this.kubeRepository = kubeRepository;
    }

    public List<Kube> findAll() {
        return kubeRepository.findAll();
    }

    public Optional findById(Long id) {
        return kubeRepository.findById(id);
    }

    public Kube add(Kube kube) {
        kubeRepository.save(kube);
        return kube;
    }

    public boolean update(Long id, Kube kube) {
        Optional<Kube> p = kubeRepository.findById(id);
        if (p.isPresent()) {
            return false;
        }
        kubeRepository.save(kube);
        return true;

    }

    public boolean delete(Long id) {
        Optional<Kube> p = kubeRepository.findById(id);
        if (p.isPresent()) {
            return false;
        }
        kubeRepository.deleteById(id);
        return true;
    }

}
