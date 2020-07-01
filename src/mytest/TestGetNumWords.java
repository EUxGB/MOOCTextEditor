package mytest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGetNumWords {
    // 130 Words
        public static String text = new String(//"fly mine. I can do it.");

                "Mr  and Mrs Dursley, of number four, Privet Drive, were proud to say that they were perfectly normal, thank you very much. They were the last people you’d expect to be involved in anything strange or mysterious, because they just didn’t hold with such nonsense.\n" +
            "\n" +
            "Mr Dursley was the director of a firm called Grunnings, which made drills. He was a big, beefy man with hardly any neck, although he did have a very large moustache. Mrs Dursley was thin and blonde and had nearly twice the usual amount of neck, which came in very useful as she spent so much of her time craning over garden fences, spying on the neighbours. The Dursleys had a small son called Dudley and in their opinion there was no finer boy anywhere.");


    public static void main(String[] args) {
        System.out.println("слов "+getNumWords());
        System.out.println("предложений "+getNumSentences());
        System.out.println("слогов = "+getNumSyllables());


    }

    protected static List<String> getTokens(String pattern) {
        ArrayList<String> tokens = new ArrayList<String>();
        Pattern tokSplitter = Pattern.compile(pattern);
        Matcher m = tokSplitter.matcher(text);
        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }

    public static int getNumWords()
    {
        List<String> listWords = getTokens("[a-zA-Z’]+");
        System.out.println(listWords);
        return listWords.size();
    }


    public static int getNumSentences()
    {
        List<String> listSentences = getTokens("[^.?!]+");
        System.out.println(listSentences);
        return listSentences.size();


    }

    public static int getNumSyllables()
    {	int i =0;
        List<String> listWords = getTokens("[a-zA-Z’]+");
        for (String words : listWords) {

            i=i+countSyllables(words);

        }
        return i;

    }
    public static int countSyllables(String word)
    {

        Pattern tokSplitter = Pattern.compile("[eyuioaEYUIOA]+");
        Matcher m = tokSplitter.matcher(word);
        int matchCount =0;
        while(m.find()){
            matchCount++;
        }
         tokSplitter = Pattern.compile("[^aeyuio]e$");
         m = tokSplitter.matcher(word);
        if (m.find()&matchCount>1) matchCount--;
        return matchCount;



        // TODO: Implement this method so that you can call it from the
        // getNumSyllables method in BasicDocument (module 2) and
        // EfficientDocument (module 3).
    }

}
