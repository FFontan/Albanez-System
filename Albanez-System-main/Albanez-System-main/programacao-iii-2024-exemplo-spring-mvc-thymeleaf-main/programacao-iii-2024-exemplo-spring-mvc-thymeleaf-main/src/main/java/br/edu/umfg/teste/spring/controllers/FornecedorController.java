package br.edu.umfg.teste.spring.controllers;

import br.edu.umfg.teste.spring.entities.Fornecedor;
import br.edu.umfg.teste.spring.repositories.EnderecoRepository;
import br.edu.umfg.teste.spring.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FornecedorController {
    private FornecedorRepository fornecedorRepository;
    private EnderecoRepository enderecoRepository;

    @Autowired
    public FornecedorController(FornecedorRepository fornecedorRepository, EnderecoRepository enderecoRepository) {
        this.fornecedorRepository = fornecedorRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping("/cadastroFornecedor")
    public String mostrarCadastro(Model model) {
        model.addAttribute("fornecedor", new Fornecedor());
        return "cadastroFornecedor";
    }

    @GetMapping("/listaFornecedor")
    public String listarFornecedor(Model model) {
        model.addAttribute("fornecedor", fornecedorRepository.findAll());
        return "listaFornecedor";
    }

    @PostMapping("/fornecedores")
    public String cadastrarFornecedor(@ModelAttribute Fornecedor fornecedor) {
        enderecoRepository.save(fornecedor.getEndereco());
        fornecedorRepository.save(fornecedor);
        return "redirect:/listaFornecedor";
    }
}