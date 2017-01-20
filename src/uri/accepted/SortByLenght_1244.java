package uri.accepted;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class SortByLenght_1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numStr = Integer.parseInt(br.readLine());

        while (numStr != 0) {
            String input = br.readLine();
            MyLinkedList ws = sortByLenght(input);
            bw.write(ws.print());
            numStr--;
        }
        bw.flush();
    }

    public static MyLinkedList sortByLenght(String input) {
        int last = 0;
        MyLinkedList ws = new MyLinkedList();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                String word = input.substring(last, i);
                last = i + 1;
                ws = addOnList(word, ws);
            } else if (i == input.length() - 1) {
                String word = input.substring(last);
                ws = addOnList(word, ws);
            }
        }

        return ws;
    }

    private static MyLinkedList addOnList(String word, MyLinkedList ws) {
        if (ws.data == null) {
            ws.data = word;
        } else {
            ws = ws.addOrderByLenght(word);
        }
        return ws;
    }

    static class MyLinkedList {

        String data;
        MyLinkedList next;

        public MyLinkedList() {
        }

        MyLinkedList(String word) {
            data = word;
        }

        private String print() {
            StringBuilder print = new StringBuilder();
            print.append("");
            if (data == null) {
                return print().toString();
            }
            MyLinkedList current = this;
            while (current.next != null) {
                if (current.next == null) {
                    break;
                }
                print.append(current.data + " ");
                current = current.next;
            }
            print.append(current.data + "\n");
            return print.toString();
        }

        private MyLinkedList addOrderByLenght(String word) {
            if (data == null) {
                data = word;
            } else {
                MyLinkedList newOne = new MyLinkedList(word);
                if (data.length() < word.length()) {
                    newOne.next = this;
                    return newOne;
                }
                MyLinkedList current = this;
                while (current.next != null) {
                    if (word.length() > current.next.data.length()) {
                        MyLinkedList tmp = current.next;
                        current.next = newOne;
                        newOne.next = tmp;
                        return this;
                    }
                    current = current.next;
                }
                current.next = newOne;
            }
            return this;
        }

    }
}
