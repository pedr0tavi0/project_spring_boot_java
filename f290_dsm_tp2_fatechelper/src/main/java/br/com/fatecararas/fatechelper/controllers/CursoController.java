package br.com.fatecararas.fatechelper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecararas.fatechelper.model.entities.Curso;
import br.com.fatecararas.fatechelper.model.services.CursoService;



@Controller
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private CursoService service;

    @GetMapping("/novo")
    public String criar(Curso curso){
        System.out.println("Passou pelos controllers");
        return "adicionar";
    }

    @PostMapping("/criar")
    public String criarCurso(Curso curso){
        service.criar(curso);
        return "redirect:/curso/todos";
    }

    @GetMapping("/todos")
    public String buscarTodos(){
        return "listar";
    }
    @ModelAttribute("cursos")
    public List<Curso> getCursos(){
       return  service.buscarTodos();
    }
}
