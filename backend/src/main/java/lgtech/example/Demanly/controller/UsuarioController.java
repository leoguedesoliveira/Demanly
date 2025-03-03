package lgtech.example.Demanly.controller;

import lgtech.example.Demanly.dto.UsuarioDTO.UsuarioResponseDTO;
import lgtech.example.Demanly.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        List<UsuarioResponseDTO> usuarioList = service.listar().stream().map(UsuarioResponseDTO::new).toList();
        return ResponseEntity.ok(usuarioList);
    }
}
