package lgtech.example.Demanly.dto.UsuarioDTO;

import lgtech.example.Demanly.entity.UserRole;

public record RegisterDTO(String nome, String email, String senha, UserRole role) {
}
