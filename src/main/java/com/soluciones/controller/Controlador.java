package com.soluciones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soluciones.interfaceService.IClienteService;
import com.soluciones.modelo.Cliente;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping({"/","/listar"})
	public String listarClientes(Model model) {
		List<Cliente>clientes = service.listar();
		model.addAttribute("clientes",clientes);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "form_cliente";
	}
	
	@PostMapping("/guardar")
	public String save(@Validated Cliente c, Model model) {
		service.save(c);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Cliente>cliente = service.listarId(id);
		model.addAttribute("cliente",cliente);
		return "form_cliente";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
}
