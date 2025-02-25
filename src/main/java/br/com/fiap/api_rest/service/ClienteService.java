package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.ClienteRequest;
import br.com.fiap.api_rest.dto.ClienteResponse;
import br.com.fiap.api_rest.model.Cliente;
import br.com.fiap.api_rest.repository.ClienteRepository;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    public Cliente requestToCliente(ClienteRequest clienteRequest){
        return new Cliente(null,
                clienteRequest.getNome(),
                clienteRequest.getIdade(),
                clienteRequest.getEmail(),
                clienteRequest.getSenha(),
                clienteRequest.getCpf(),
                clienteRequest.getCategoria()
        );
    }

    public ClienteResponse clienteToResponse(Cliente cliente){
        return new ClienteResponse(cliente.getId(), cliente.getNome());
    }

    public List<ClienteResponse> clienteResponses(List<Cliente> clientes){
        List<ClienteResponse> clienteResponses = new ArrayList<>();
        for (Cliente cliente : clientes){
            clienteResponses.add(clienteToResponse(cliente));
        }
        return clienteResponses;
        //return clientes.stream().map(cliente -> clienteToResponse(cliente)).collect(Collectors.toList());
    }
    public Page<ClienteResponse> findAll(Pageable pageable){
        // quero buscar todos os clientes, converte-los pra response dentro de uma pagina
        //return clienteRepository.findAll(pageable).map(cliente -> clienteToResponse(cliente));
        return clienteRepository.findAll(pageable).map(this::clienteToResponse);
    }
}