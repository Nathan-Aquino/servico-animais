package org.treinamento.servico_animais.controladores;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.treinamento.servico_animais.entidades.Animal;
import org.treinamento.servico_animais.repositorios.AnimalRepositorio;



@RestController
@RequestMapping("/animais")
public class AnimalControlador {

    @Autowired
    private AnimalRepositorio repositorio;
    
    @GetMapping
    private List<Animal> listarAnimais () {
        return repositorio.findAll();
    }

    @PostMapping
    public Animal cadastrarAnimal(@RequestBody Animal animal) {
        return repositorio.save(animal);
    }
    
    @GetMapping("/nao-adotados")
    public List<Animal> listarAnimaisNaoAdotados () {
        return repositorio.listarNaoAdotados();
    }
    
    @GetMapping("/adotados")
    public List<Animal> listarAnimaisAdotados() {
        return repositorio.listarAdotados();
    }

    @GetMapping("/contagem-resgate")
    public List<Object[]> listarContagemAnimaisResgatadosPorFuncionario (
            @RequestParam("dataInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") String dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(pattern = "yyyy-MM-dd") String dataFim
    ) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Date dataInicioSQL = new Date(formato.parse(dataInicio).getTime());
        Date dataFimSQL = new Date(formato.parse(dataFim).getTime());

        return repositorio.contarAnimaisResgatadosPorFuncionario(dataInicioSQL, dataFimSQL);
    }
    
    
}
