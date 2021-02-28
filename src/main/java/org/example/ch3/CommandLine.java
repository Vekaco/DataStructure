package org.example.ch3;

import java.util.Scanner;

public class CommandLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            String next = scanner.next();
            if (next.equals("@@")) {
                running =false;
            }
            char[] in = next.toCharArray();
            Stack<Character> stack = new Stack<>();
            int i = 0;
            while (i < in.length) {
                if (in[i] == '#') {
                    stack.pop();
                } else if (in[i] == '@') {
                    stack.clear();
                } else {
                    stack.push(in[i]);
                }
                i++;
            }

            Stack<Character> result = new Stack<>();
            while (!stack.isEmpty()) {
                result.push(stack.pop());
            }

            while(!result.isEmpty()) {
                System.out.print(result.pop());
            }
        }
    }
}
