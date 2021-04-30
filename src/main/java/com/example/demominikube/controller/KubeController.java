package com.example.demominikube.controller;

import com.example.demominikube.model.Kube;
import com.example.demominikube.repos.KubeRepository;
import com.example.demominikube.service.KubeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * KubeController
 *
 * @author Вершинин Пётр
 */
@RestController
public class KubeController {

    private final KubeService kubeService;
    private final KubeRepository kubeRepository;

    public KubeController(KubeService kubeService, KubeRepository kubeRepository) {
        this.kubeService = kubeService;
        this.kubeRepository = kubeRepository;
    }

    @GetMapping
    public ResponseEntity<String> index() {

        return new ResponseEntity(kubeService.findAll(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<String> get(@PathVariable Long id) {
        return new ResponseEntity(kubeService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Kube> create(@RequestBody @Valid Kube kube){
        Kube kub= kubeRepository.save(kube);
        return ResponseEntity.status(201).body(kub);

    }
    @PutMapping("{id}")
    public ResponseEntity<String> update(@RequestBody Kube kube,@PathVariable Long id){

        if(!kubeService.update(id,kube)){
            return ResponseEntity.badRequest()
                    .body("Kube having ID = "+id+ " doesn't exist");
        }
        return new ResponseEntity(kube,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public String remove(@PathVariable Long id){
        if(kubeService.delete(id)){
           return  "Kube having ID = "+id+ " doesn't exist";
        }
        return "Kube having ID = "+id+ " is removed";
    }
}
