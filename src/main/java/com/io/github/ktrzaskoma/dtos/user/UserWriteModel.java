package com.io.github.ktrzaskoma.dtos.user;

import com.io.github.ktrzaskoma.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserWriteModel {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Email(message = "Email is not valid!")
    private String email;
    private String password;

    public static User toEntity(final UserWriteModel writeModel) {
        var entity = new User();
        entity.setFirstName(writeModel.getFirstName());
        entity.setLastName(writeModel.getLastName());
        entity.setPhoneNumber(writeModel.getPhoneNumber());
        entity.setEmail(writeModel.getEmail());
        entity.setPassword(writeModel.getPassword());

        return entity;

    }
}
