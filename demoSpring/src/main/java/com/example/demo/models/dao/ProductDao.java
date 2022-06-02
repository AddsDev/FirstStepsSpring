package com.example.demo.models.dao;

import com.example.demo.models.ProductoRepository;
import com.example.demo.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository("productDao")//Para defirnir la clase con acceso a datos
public class ProductDao implements IProductDao{

    @Autowired
    private ProductoRepository repository;

    @Transactional
    @Override
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @Override
    public Producto get(Long id) {
        return repository.getById(id);
    }

    @Override
    @Transactional
    public Producto register(Producto newProducto) {
//        manager.getTransaction().begin();
//        manager.persist(newProducto);
//        manager.getTransaction().commit();

        return repository.save(newProducto);
    }

    @Override
    public Producto update(Long id, Producto producto) {
        return repository.findById(id).map(pro ->{
            pro.setCantidad(producto.getCantidad());
            pro.setNombre(producto.getNombre());
            pro.setPrecio(producto.getPrecio());
            pro.setPrecioVenta(producto.getPrecioVenta());
            return  repository.save(pro);
        }).orElseGet(()->{
            producto.setId(id);
            return repository.save(producto);
        });
    }

    @Override
    public Producto remove(Long id) {
        Producto temp = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return temp;
    }
}
