package uri.accepted;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class ThrowingCardsAway_1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int input = Integer.valueOf(br.readLine());

        while (input != 0) {

            StringBuilder partial = throwingCardsAway(input);
            answer.append(partial + "\n");
            input = Integer.valueOf(br.readLine());
        }

        bw.write(answer.toString());
        bw.flush();
    }

    public static StringBuilder throwingCardsAway(int n) {
        if (n == 1) {
            return new StringBuilder("1");
        }

        StringBuilder partial = new StringBuilder();
        partial.append("Discarded cards: ");

        LinkedList<Integer> list = new LinkedList<Integer>();
        int count = 1;
        while (count <= n) {
            list.add(count);
            count++;
        }

        Iterator<Integer> iterator = list.iterator();
        while (list.size() != 1) {
            Integer discarted = iterator.next();

            if (list.size() == 2) {
                partial.append(discarted);
            } else {
                partial.append(discarted + ", ");

            }

            iterator.remove();
            Integer addEnd = iterator.next();
            iterator.remove();
            list.addLast(addEnd);
            iterator = list.iterator();
        }
        partial.append("\n");
        partial.append("Remaining card: " + list.get(0));
        return partial;
    }
}
