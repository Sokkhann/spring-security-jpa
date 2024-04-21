package org.example.springsecurityjpa.restController;

// this class for articles
// contain some features such as get all, get single, create, and delete article

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/articles")
public class ArticleRestController {

    // for get all articles
    @GetMapping()
    public String getAllArticle() {
        return "Get All Articles Successfully!";
    }

    // for get single article
    @GetMapping("/get/{id}")
    public String getSingleArticle(@PathVariable int id) {
        return "Get a Single Article Successfully!";
    };

    @PostMapping("/delete/{id}")
    public String deleteArticle(@PathVariable int id) {
        return "Delete Article by ID Successfully!";
    }

}
