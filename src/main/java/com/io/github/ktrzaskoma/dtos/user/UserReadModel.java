package com.io.github.ktrzaskoma.dtos.user;

import com.io.github.ktrzaskoma.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserReadModel {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    public static UserReadModel toReadModel(final User entity) {
        return new UserReadModel(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}
