package br.com.pedrocavalcanti.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

//Quando tem isso: <> é por que recebe um generator
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
    
}
