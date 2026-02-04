package com.vinicius.user_api.business;


import com.vinicius.user_api.business.converter.UsuarioConverter;
import com.vinicius.user_api.business.dto.UsuarioDTO;
import com.vinicius.user_api.insfrastructure.entity.Usuario;
import com.vinicius.user_api.insfrastructure.exception.ConflictException;
import com.vinicius.user_api.insfrastructure.exception.ResourceNotFoundException;
import com.vinicius.user_api.insfrastructure.repository.UsuarioRepository;
import com.vinicius.user_api.insfrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        Usuario usuarioEntity = usuarioConverter.paraUsuario(usuarioDTO);
        return  usuarioConverter.paraDTO(usuarioRepository.save(usuarioEntity));
    }

    public void  emailExiste(String email){
        try{
            boolean existe = verificarEmailExistente(email);
            if (existe) {
                throw new ConflictException("Email ja cadastrado " + email);
            }
        } catch (ConflictException e){
            throw new ConflictException("Email ja cadastrado " + e);
        }
    }

    public boolean verificarEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email nao encontrado! " + email));
    }

    public void deletarUsuarioPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }

    public UsuarioDTO atualizarDadosUsuario(String token, UsuarioDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));
        dto.setSenha(dto.getSenha() != null ? passwordEncoder.encode(dto.getSenha()) : null);
        Usuario usuarioEntity =  usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Email nao encontrado! : " +  email));
        Usuario usuario = usuarioConverter.updateUsuario(dto,usuarioEntity);

        return usuarioConverter.paraDTO(usuarioRepository.saveAndFlush(usuario));

    }

}
