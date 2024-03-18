package ru.kulikov.nexign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.kulikov.nexign.utils.Trie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class NexignApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexignApplication.class, args);
	}


	@Bean(name = "parsedFile")
	public Trie readFile() throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("file.txt"));

		Trie root = new Trie(' ');
		for (String line: lines) {
			root.insert(line);
		}

		return root;
	}

}
