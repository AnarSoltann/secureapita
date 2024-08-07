package com.ansdev.secureapita.resource;

import com.ansdev.secureapita.domain.HttpResponse;
import com.ansdev.secureapita.domain.User;
import com.ansdev.secureapita.dto.UserDTO;
import com.ansdev.secureapita.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static java.util.Map.of;

import static java.time.LocalDateTime.now;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<HttpResponse> saveUser(@RequestBody @Valid User user) {
         UserDTO userDTO= userService.createUser(user);
        return ResponseEntity.created(getUri()).body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("user", userDTO))
                        .message("User created successfully")
                        .httpStatus(HttpStatus.CREATED.toString())
                        .httpStatusCode(HttpStatus.CREATED.value())
                        .build());
    }

    private URI getUri() {
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/user/get/<userId>").toUriString());
    }


}

