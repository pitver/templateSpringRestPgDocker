package com.example.demominikube.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * Kube
 *
 * @author Вершинин Пётр
 */
@Entity
public class Kube implements Serializable {

    @NotNull
    private String name;
    private float length;
    private float breadth;
    private float height;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Kube() {
    }

    public Kube(String name, float length, float breadth, float height) {
        this.name = name;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getBreadth() {
        return breadth;
    }

    public void setBreadth(float breadth) {
        this.breadth = breadth;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kube kube = (Kube) o;
        return Float.compare(kube.length, length) == 0 &&
                Float.compare(kube.breadth, breadth) == 0 &&
                Float.compare(kube.height, height) == 0 &&
                id == kube.id && Objects.equals(name, kube.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, breadth, height, id);
    }

    @Override
    public String toString() {
        return "Kube{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", breadth=" + breadth +
                ", height=" + height +
                ", id=" + id +
                '}';
    }
}
