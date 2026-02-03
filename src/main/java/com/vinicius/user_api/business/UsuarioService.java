package com.vinicius.user_api.business;


import com.vinicius.user_api.business.converter.UsuarioConverter;
import com.vinicius.user_api.business.dto.UsuarioDTO;
import com.vinicius.user_api.insfrastructure.entity.Usuario;
import com.vinicius.user_api.insfrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuarioEntity = usuarioConverter.paraUsuario(usuarioDTO);
        return  usuarioConverter.paraDTO(usuarioRepository.save(usuarioEntity));
    }

}
