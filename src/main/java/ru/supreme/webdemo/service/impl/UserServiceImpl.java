package ru.supreme.webdemo.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.supreme.webdemo.model.dto.UserDTO;
import ru.supreme.webdemo.model.entity.UserEntity;
import ru.supreme.webdemo.repository.UserRepository;
import ru.supreme.webdemo.service.UserService;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public boolean checkAuth(UserDTO userDTO) {
        UserEntity userFromDB = userRepository.findUserByUsername(userDTO.getUsername());
        if (userFromDB == null) {
            return false;
        }
//        UserEntity userFromRequest = userMapper.dtoToEntity(userDTO);
        if (passwordEncoder.matches(userDTO.getPassword(), userFromDB.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserDTO registration(UserDTO userDTO) {
        if (userRepository.findUserByUsername(userDTO.getUsername()) != null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setUsername(userDTO.getUsername());
        userRepository.save(userEntity);
        return userMapper.entityToDTO(userEntity);
    }

    public void kek() {

        InputStream io = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        try (InputStream io1 = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        }) {




        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            //
        } catch (Exception e) {
            //

        } finally {
            try {
                io.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


