package org.example.springsecurityjpa.restController;
import lombok.RequiredArgsConstructor;
import org.example.springsecurityjpa.model.dto.UserRequest;
import org.example.springsecurityjpa.model.dto.UserResponse;
import org.example.springsecurityjpa.service.UserService;
import org.example.springsecurityjpa.utils.BaseResponse;
import org.springframework.web.bind.annotation.*;

// this class is for authentication
// such as register, sign up, login, or log out@RestController
@RestController
@RequiredArgsConstructor
public class AuthRestController {
    private final UserService userService;

    @GetMapping("/register")
    public String home() {
        return "Hello";
    }

    @PostMapping("/register")
    public BaseResponse<UserResponse> createNewUser(@RequestBody UserRequest userRequest) {
        return BaseResponse.<UserResponse>createSuccess()
                .setPayload(userService.createUser(userRequest));

    }
}