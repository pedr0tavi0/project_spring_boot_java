package br.com.fatecararas.fatechelper.model.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.com.fatecararas.fatechelper.model.entities.Curso;
import br.com.fatecararas.fatechelper.model.repositories.CursoRepository;



@Service
public class CursoService {


    private final CursoRepository repository;
    
    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }



    public Curso criar(Curso pCurso){
        return repository.save(pCurso);
    }

    
    public Curso buscarPorId(Integer pId){
        Optional<Curso> optional =  repository.findById(pId);

        if(!optional.isPresent()) 
            throw new RuntimeException("Curso não encontrado. ID " + pId);


         return optional.get();

  
    }

    public void excluir(Integer pId){
        repository.deleteById(pId);

     }


     public Curso atualizar(Curso pCurso){
       Integer id =  pCurso.getId();
       Curso curso = buscarPorId(id);

       curso.setNome(pCurso.getNome());
       curso.setDescricao(pCurso.getDescricao());

       return repository.save(curso);
    
    }


    public List<Curso> buscarTodos(){
        return repository.findAll();
    }
}
