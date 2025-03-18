package br.com.fiap.api_rest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String senha;
    private String cpf;
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_filial")
    private Filial filial;
    @ManyToMany
    @JoinTable(name = "grupo_cliente",
            joinColumns = @JoinColumn(name = "id_grupo", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_cliente", referencedColumnName = "id"))
    private List<Grupo> grupos;

}