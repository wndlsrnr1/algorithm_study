package algorithm.study.level1;

import java.util.Arrays;
import java.util.Comparator;
/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12915
    문자열 Comparator 구현해서 정렬

 */
class Word{
    String word;
    int nth;
    public static Comparator<Word> comparator = new Comparator<Word>() {
        @Override
        public int compare(Word o1, Word o2) {
            char elem1 = o1.word.charAt(o1.nth);
            char elem2 = o2.word.charAt(o2.nth);
            if (elem1 > elem2){
                return 1;
            }else if(elem1 < elem2){
                return -1;
            }else {
                int compare = o1.word.compareTo(o2.word);
                return compare;
            }
        }
    };


    public Word(String word, int nth) {
        this.word = word;
        this.nth = nth;
    }

    public String getWord() {
        return word;
    }
}
public class SortingWordsInMyWay {

    public String[] solution(String[] strings, int n) {

        int size = strings.length;
        Word[] words = new Word[size];

        for (int i = 0; i < size; i++) {
            words[i] = new Word(strings[i], n);
        }

        Arrays.sort(words, Word.comparator);
        String[] answer = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            answer[i] = words[i].word;
        }

        return answer;
    }

}
