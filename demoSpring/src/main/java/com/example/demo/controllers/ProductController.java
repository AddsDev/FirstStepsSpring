package com.example.demo.controllers;

import com.example.demo.models.ProductoRepository;
import com.example.demo.models.dao.IProductDao;
import com.example.demo.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product", consumes = "application/json", produces = "application/json")
public class ProductController {

//    @Autowired //Inyeccion de dependencias automatico del @component
//    @Qualifier("product") //Se define cual @component desea inyectar
//    private IRecords records;
    @Autowired
    @Qualifier("productDao")
    private IProductDao productDao;
    @Autowired
    private ProductoRepository repository;

    @GetMapping(path = {"", "/"})
    public List<Producto> index(){
        return productDao.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public Producto index(@PathVariable("id") Long id){
        return productDao.get(id);
    }

    @PostMapping(path = {"","/"} , consumes = "application/json", produces = "application/json")
    public Producto register(@RequestBody  Producto producto){
        productDao.register(producto);
        return producto;
    }

    @PutMapping(path = {"/{id}"})
    public Producto update(@PathVariable("id") Long id,@RequestBody Producto producto){
        return productDao.update(id, producto);
    }

    @DeleteMapping(path = "/{id}")
    public Producto remove(@PathVariable("id") Long id){
        return productDao.remove(id);
    }

}
