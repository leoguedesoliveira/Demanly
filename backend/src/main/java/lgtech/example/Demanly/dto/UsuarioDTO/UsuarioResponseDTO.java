package lgtech.example.Demanly.dto.UsuarioDTO;

import lgtech.example.Demanly.entity.Usuario;

public record UsuarioResponseDTO(Integer id, String nome, String email, String senha) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
