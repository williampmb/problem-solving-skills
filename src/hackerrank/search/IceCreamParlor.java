package hackerrank.search;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author William
 */
public class IceCreamParlor {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int trips = Integer.parseInt(br.readLine());
        while (trips != 0) {
            int money = Integer.valueOf(br.readLine());
            int flavos = Integer.valueOf(br.readLine());
            IceCream[] choices = spendAllMoney(money, br.readLine());
            if (choices != null) {
                System.out.println(choices[0].flavor + " " + choices[1].flavor);
            }
            trips--;
        }
    }

    private static IceCream[] spendAllMoney(int money, String readLine) {
        String[] cost = readLine.split(" ");
        IceCream[] order = new IceCream[2];
        Map<Integer, IceCream> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            int ith = i + 1;
            IceCream ice = new IceCream(ith, Integer.valueOf(cost[i]));
            if (map.get(money - ice.value) == null) {
                map.put(ice.value, ice);
            } else {
                IceCream match = map.get(money - ice.value);
                if (match.flavor > ice.flavor) {
                    order[0] = ice;
                    order[1] = match;
                } else {
                    order[0] = match;
                    order[1] = ice;
                }

                return order;
            }
        }
        return null;
    }

    public static class IceCream {

        int value;
        int flavor;

        public IceCream(int f, int v) {
            flavor = f;
            value = v;
        }
    }
}
