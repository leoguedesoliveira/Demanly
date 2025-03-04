package lgtech.example.Demanly.services;

import lgtech.example.Demanly.dto.UsuarioDTO.UsuarioRequestDTO;
import lgtech.example.Demanly.entity.Usuario;
import lgtech.example.Demanly.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listar() {
        return repository.findAll();
    }
}
