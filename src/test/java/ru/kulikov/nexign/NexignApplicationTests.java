package ru.kulikov.nexign;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kulikov.nexign.utils.Trie;
import static org.hamcrest.CoreMatchers.equalTo;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NexignApplicationTests {

	@Test
	void wordFind(){
		List<String> allWords = new ArrayList<>();
		allWords.add("catalog");
		allWords.add("catalog");
		allWords.add("catalog");
		allWords.add("cat");
		allWords.add("dog");
		allWords.add("dog");

		Trie root = new Trie(' ');
		for (String line: allWords) {
			root.insert(line);
		}

		MatcherAssert.assertThat(root.findCountOfWord("catalog"), equalTo(3));
		MatcherAssert.assertThat(root.findCountOfWord("cat"), equalTo(1));
		MatcherAssert.assertThat(root.findCountOfWord("ca"), equalTo(0));
		MatcherAssert.assertThat(root.findCountOfWord("dog"), equalTo(2));
	}

}
