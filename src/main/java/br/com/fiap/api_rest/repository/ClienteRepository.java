package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeAndIdade(String nome, int idade);
    List<Cliente> findByTop3ByIdade(int idade);
    List<Cliente> findByIdadeIs(int idade);
    List<Cliente> findByEmailIsNull();
    List<Cliente> findByNomeIsNot(String nome);
    List<Cliente> findByNomeIsNotEquals(String nome);
    List<Cliente> findByVipTrue();
    List<Cliente> findByVipFalse();
    List<Cliente> findByDataNascimento(Data dataNascimento);
    List<Cliente> findByIdStartWith(Long prefix);
    List<Cliente> findByNomeAndVipTrue();
}