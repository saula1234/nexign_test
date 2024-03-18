package ru.kulikov.nexign.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kulikov.nexign.utils.Trie;

@RestController
public class MainController {

    Trie parsedFile;

    public MainController(Trie parsedFile) {
        this.parsedFile = parsedFile;
    }

    @GetMapping(value = "/word-count")
    public ResponseEntity<Integer> uploadVideo(@RequestBody String word) {

        Integer result = parsedFile.findCountOfWord(word);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
