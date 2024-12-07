package br.edu.umfg.teste.spring.controllers;

import br.edu.umfg.teste.spring.entities.Produto;
import br.edu.umfg.teste.spring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/cadastroProduto")
    public String mostrarCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastroProduto";
    }

    @GetMapping("/listaProduto")
    public String listarProduto(Model model) {
        model.addAttribute("produto", produtoRepository.findAll());
        return "listaProduto";
    }

    @PostMapping("/produtos")
    public String cadastrarProdutos(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/listaProduto";
    }
}