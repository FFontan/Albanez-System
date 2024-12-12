package br.edu.umfg.teste.spring.controllers;

import br.edu.umfg.teste.spring.entities.Funcionario;
import br.edu.umfg.teste.spring.repositories.EnderecoRepository;
import br.edu.umfg.teste.spring.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FuncionarioController {
    private FuncionarioRepository funcionarioRepository;
    private EnderecoRepository enderecoRepository;

    @Autowired
    public FuncionarioController(FuncionarioRepository funcionarioRepository, EnderecoRepository enderecoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.enderecoRepository = enderecoRepository;
    }

    // Página inicial
    @GetMapping("/")
    public String mostrarIndex() {
        return "index"; // Retorna a página index.html
    }

    // Página para cadastro de cliente
    @GetMapping("/cadastroFuncionario")
    public String mostrarCadastro(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "cadastroFuncionario"; // Retorna a página cadastroFuncionario.html
    }

    // Página para listar clientes
    @GetMapping("/listaFuncionario")
    public String listarFuncionario(Model model) {
        model.addAttribute("funcionario", funcionarioRepository.findAll());
        return "listaFuncionario"; // Retorna a página listaFuncionario.html
    }

    // Método para salvar o cliente após o cadastro
    @PostMapping("/funcionarios")
    public String cadastrarFuncionarios(@ModelAttribute Funcionario funcionario) {
        enderecoRepository.save(funcionario.getEndereco());
        funcionarioRepository.save(funcionario);
        return "redirect:/listaFuncionario";  // Redireciona para a página de listagem de clientes
    }
}