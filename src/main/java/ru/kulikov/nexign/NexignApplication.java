package ru.kulikov.nexign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.kulikov.nexign.utils.Trie;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class NexignApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexignApplication.class, args);
	}


	@Bean(name = "parsedFile")
	public Trie readFile() throws IOException {

		List<String> lines = Files.readAllLines(Paths.get("text.txt"));

		List<String> allWords = new ArrayList<>();

		for (String s : lines) {

		BreakIterator breakIterator = BreakIterator.getWordInstance();
		breakIterator.setText(s);
		int lastIndex = breakIterator.first();
		while (BreakIterator.DONE != lastIndex) {
			int firstIndex = lastIndex;
			lastIndex = breakIterator.next();
			if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(s.charAt(firstIndex))) {
				allWords.add(s.substring(firstIndex, lastIndex));
			}
		}
		}

		System.out.println(lines);

		System.out.println(allWords);

		Trie root = new Trie(' ');
		for (String line: allWords) {
			root.insert(line);
		}

		return root;
	}

}
