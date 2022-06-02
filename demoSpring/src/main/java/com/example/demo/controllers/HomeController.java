package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.HashMap;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    //@RequestMapping(path = "/", method = RequestMethod.GET)//value o path
    @GetMapping(path = {"/saludo","/bye"})
    public HashMap<String, String> home(){

        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return map;
    }
    @GetMapping(path = "/name")
    public String name(){
        return "Name del player";
    }

    @GetMapping(path = {"/send",""})
    public String send(){
        return  "index";
    }

    @GetMapping(path = "/usuario")
    public Object usuario(@RequestParam String apellido, @RequestParam(name = "nombre") String name){ //se usa el @RequestParam(name -> para especificar el nombre del parametro)
        Usuario usuario = new Usuario(name, apellido);

        return usuario;
    }
    @GetMapping(path = "usuario-request")
    public Object usuario(HttpServletRequest request){
        Usuario usuario = new Usuario(request.getParameter("nombre"), request.getParameter("apellido"));

        return usuario;
    }

    @GetMapping(path = "/usuario/{name}/{last}")
    public Object usuarioPath(@PathVariable(name = "name") String nombre, @PathVariable(name = "last") String apellido){
        Usuario usuario = new Usuario(nombre, apellido);

        return usuario;
    }
}
