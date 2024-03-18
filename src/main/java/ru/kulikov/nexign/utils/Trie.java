package ru.kulikov.nexign.utils;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    char value;
    List<Trie> children;
    boolean endOfWord = false;
    int sameWordsCounter = 0;

    public Trie(char value) {
        this.value = value;
    }

    public void insert(String data) {
        if (data.length() == 0) {

            if (endOfWord){
                sameWordsCounter++;
            }
            else {
                endOfWord = true;
                sameWordsCounter++;
            }

            return;

        }
        if (children == null) {
            children = new ArrayList<>();

        }
        char c = data.charAt(0);
        Trie child = findNodeByChar(c);
        if (child == null) {
            child = new Trie(c);
            children.add(child);
        }
        child.insert(data.substring(1)); //рекурсивно вызываем функцию

    }

    public Trie findNodeByChar(char c) {

        if (children != null) {
            for(Trie node: children) {
                if (node.value == c) {
                    return node;
                }
            }
        }
        return null;
    }

    public int findCountOfWord(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            current = current.findNodeByChar(word.charAt(i));
            if (current == null) {
                return 0;
            }
        }
        return current.sameWordsCounter;
    }

}
