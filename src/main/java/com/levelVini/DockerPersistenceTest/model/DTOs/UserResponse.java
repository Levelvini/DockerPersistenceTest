package com.levelVini.DockerPersistenceTest.model.DTOs;

import com.levelVini.DockerPersistenceTest.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    Long id;
    String name;
    String email;


    public UserResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static UserResponse toUserResponse(User user){
        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
        return userResponse;
    }
}
// não consegui retornar uma lista de IDs com as orders vinculadas a usuarios especificos, aparentemente isso é feito com o @Query do JPA, em breve dou um jeito nisso!!
