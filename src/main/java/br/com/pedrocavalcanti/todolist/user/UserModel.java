package br.com.pedrocavalcanti.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

//A lib(=library) Lombok facilita a vida, ele ja importa os Getters e Setter dos atributos
@Data
@Entity(name = "tb_users")
//Chave primária é um ID, uma referência, que repreenta o dadoq ue estamos inserindo an nossa aplicação
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    @Column(unique = true)
    public String username;
    public String name;
    public String password;

    // Métodos getter e setters
    // Set para inserir o valor
    // E o Get para buscar/retornar o valor

    @CreationTimestamp
    private LocalDateTime crateAt;

}
