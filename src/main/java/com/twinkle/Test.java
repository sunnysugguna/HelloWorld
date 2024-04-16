package com.twinkle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String fileName = "C:/Users/haris/Downloads/coding_qual_input.txt"; // Specify the path to your file
        String lines = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
               lines = lines + line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(returnSentence(lines));
    }

    public static String returnSentence(String s) {

        if (s != null && !s.isEmpty()) {
            String sentence = "";
            Map<Integer, String> wordNumberMap = new HashMap<Integer, String>();
            String[] lines = s.split("\\n");
            for (String line : lines) {
                String[] words = line.split(" ");
                wordNumberMap.put(Integer.valueOf(words[0]), words[1]);
            }

            String pyramid = createSequentialPyramid(wordNumberMap.size());
            String[] pyramidLines = pyramid.split("\\n");

            for (String pyramidLine : pyramidLines) {
                String[] pyramidLineWds = pyramidLine.split(" ");
                String lastnum = pyramidLineWds [pyramidLineWds.length - 1];
                sentence = sentence + " " + wordNumberMap.get(Integer.valueOf(lastnum));
            }
            return sentence;
        }

        return "";
    }

    public static String createSequentialPyramid(int rows) {
        String pyramid = "";
        int number = 1;
        for (int i = 1; i <= rows; i++) {
            String line = "";
            for (int k = 1; k <= i; k++) {
               line = line + number + " "; // Print numbers
                number++; // Increment number
            }
            line = line + "\n";

            pyramid = pyramid + line;

        }
        return pyramid;
    }
}
