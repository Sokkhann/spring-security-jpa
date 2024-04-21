package org.example.springsecurityjpa.restController;

import org.springframework.web.bind.annotation.*;

// this class for admins authority
// what admins can do
// such as getAllUser, createArticle, and deleteUser
@RestController()
@RequestMapping("api/v1/admins")
public class AdminRestController {

    // for get all user
    @GetMapping()
    public String getAllUser() {
        return "Get All User Successfully!";
    }

    // for create article
    @PostMapping("/create")
    public String createArticle() {
        return "Create Article Successfully!";
    }

    // for delete user
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return "Delete User Successfully!";
    }
}
