package br.com.pedrocavalcanti.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Modificadores:
 * public - qualquer um pode acessar a classe
 * private - somente alguns atributos são permitidos
 * protected - só acessa quando esta na emsma estrutura do pacote
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    /**
     * String - text
     * Interger - Numéros inteiros
     * Double - Números decimais
     * Float - numero decimais com mais casas
     * Char - Caracteres
     * Date - Data
     * void - Quando não tem retorno no método
     */
    /*
     * Body
     */

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            //Mensagem de erro
            // Status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
        }

        var passwordHashsred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashsred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
}
