package com.vinicius.user_api.business.converter;

import com.vinicius.user_api.business.dto.EnderecoDTO;
import com.vinicius.user_api.business.dto.TelefoneDTO;
import com.vinicius.user_api.business.dto.UsuarioDTO;
import com.vinicius.user_api.insfrastructure.entity.Endereco;
import com.vinicius.user_api.insfrastructure.entity.Telefone;
import com.vinicius.user_api.insfrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConverter {

    // DTO -> Entity

    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecoDTOS()))
                .telefones(paraListaTelefones(usuarioDTO.getTelefoneDTOS()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){
        List<Endereco> enderecos = new ArrayList<>();
        for (EnderecoDTO enderecoDTO : enderecoDTOS){
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO){
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO  telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    // Entity -> DTO

    public UsuarioDTO paraDTO(Usuario usuario){
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecoDTOS(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefoneDTOS(paraListaTelefoneDTO(usuario.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoList){
        List<EnderecoDTO> enderecosDTO  = new ArrayList<>();

        for (Endereco endereco : enderecoList){
            enderecosDTO.add(paraEnderecoDTO(endereco));
        }

        return enderecosDTO;
    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco){
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefones){
        return telefones.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone){
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

}
