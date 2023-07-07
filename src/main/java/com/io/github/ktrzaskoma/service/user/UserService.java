package com.io.github.ktrzaskoma.service.user;

import com.io.github.ktrzaskoma.dtos.user.UserReadModel;
import com.io.github.ktrzaskoma.dtos.user.UserWriteModel;
import com.io.github.ktrzaskoma.model.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserReadModel saveUser(final UserWriteModel writeModel) {
        return UserReadModel.toReadModel(userRepository.save(UserWriteModel.toEntity(writeModel)));
    }

    public List<UserReadModel> showAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserReadModel::toReadModel)
                .toList();
    }
}
