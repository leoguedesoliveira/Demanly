package lgtech.example.Demanly.controller;

import jakarta.validation.Valid;
import lgtech.example.Demanly.dto.UsuarioDTO.AuthenticationDTO;
import lgtech.example.Demanly.dto.UsuarioDTO.RegisterDTO;
import lgtech.example.Demanly.entity.Usuario;
import lgtech.example.Demanly.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(this.repository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        } else {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
            Usuario newUsuario = new Usuario(data.nome(), data.email(), encryptedPassword, data.role());

            this.repository.save(newUsuario);
            return ResponseEntity.ok().build();
        }
    }
}
