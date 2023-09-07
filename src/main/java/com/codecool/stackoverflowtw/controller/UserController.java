package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.UserDTO;
import com.codecool.stackoverflowtw.controller.dto.newUserDTO;
import com.codecool.stackoverflowtw.service.QuestionService;
import com.codecool.stackoverflowtw.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("users")
    public class UserController {
        private final UsersService usersService;

        @Autowired
        public UserController(UsersService usersService) {
            this.usersService = usersService;
        }

        @GetMapping("/all")
        public List<UserDTO> getAllUsers() {
            return usersService.getAllUsers();
        }

        @GetMapping("/{user_name}")
        public UserDTO getUserByName(@PathVariable String user_name) {
            return usersService.getUserByName(user_name);
        }

        @PostMapping("/")
        public int addNewUser(@RequestBody newUserDTO newUserDTO) {
            return usersService.addNewUser(newUserDTO.username(),newUserDTO.password());
        }

        @DeleteMapping("/{user_name}")
        public boolean deleteUserById(@PathVariable String user_name) {
            return false;
        }
}
