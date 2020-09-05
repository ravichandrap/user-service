package com.lamina.user.service;

import com.lamina.user.controller.User;
import com.lamina.user.controller.UserDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    final int USERS_SIZE = 10;
    final User user;
    final UserDto userDto;
    final List<UserDto> users = new ArrayList<>(USERS_SIZE);

    UserServiceTest() {
        user = new User(
                "Sarala",
                "Penumuru",
                "27-03-1981",
                "Thalapula Palli",
                "909090900",
                "sarala@example.com", 3000000);
        userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        IntStream.range(0, USERS_SIZE).forEach(i -> {
            users.add(new UserDto(
                    i,
                    "Sarala-" + i,
                    "Penumuru-" + i,
                    "27-03-1981-" + i,
                    "Thalapula Palli-" + i,
                    "909090900-" + i,
                    "sarala@example.com-" + i));
        });
    }

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void shouldSaveUserSuccessFully() {
        when(userRepository.save(userDto)).thenReturn(userDto);
        logger.info("user: {}", user.toString());
        User userResult = userService.save(user);
        logger.info("userResult: {}", userResult.toString());
        assertNotNull(userResult);
    }

    @Test
    void shouldUpdateUserSuccessFully() {
        when(userRepository.save(userDto)).thenReturn(userDto);
        logger.info("user: {}", user.toString());
        User userResult = userService.update(user);
        logger.info("userResult: {}", userResult.toString());
        assertNotNull(userResult);
    }

    @Test
    void shouldFindUserSuccessFully() {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(userDto));
        User userResult = userService.get(user.getId());
        assertNotNull(userResult);
    }

    @Test
    void shouldFindUserIdSuccessFully() {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(userDto));
        User userResult = userService.get(user.getId());
        assertEquals(userResult.getId(), userDto.getId());
    }

    @Test
    void shouldDeleteUserSuccessFully() {
        UserDto dto = mock(UserDto.class);
        doNothing().when(userRepository).delete(userDto);
        //verify(dto);
    }

    @Test
    void shouldFindAllUsersSuccessFully() {
        when(userRepository.findAll()).thenReturn(users);
        List<User> userResult = userService.getUsers();
        assertNotNull(userResult);
        assertEquals(USERS_SIZE, userResult.size());
    }

}
