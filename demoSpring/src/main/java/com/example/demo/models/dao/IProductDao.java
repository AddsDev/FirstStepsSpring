package com.example.demo.models.dao;

import com.example.demo.models.entity.Producto;

import java.util.List;

public interface IProductDao {
    List<Producto> getAll();
    Producto get(Long id);
    Producto register(Producto producto);
    Producto update(Long id, Producto producto);
    Producto remove(Long id);
}
