package com.example.demo;

import com.example.demo.models.ProductoRepository;
import com.example.demo.models.entity.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

//    @Bean
//    CommandLineRunner initDatabase(ProductoRepository repository) {
//
////        return args -> {
////            log.info("Preloading " + repository.save(new Producto()));
////            log.info("Preloading " + repository.save(new Producto()));
////        };
//        return ;
//    }
}
