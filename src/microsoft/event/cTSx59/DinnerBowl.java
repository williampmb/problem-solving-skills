/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microsoft.event.cTSx59;

import java.util.Scanner;

/**
 *
 * @author William
 */
public class DinnerBowl {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        StringBuilder sb= new StringBuilder();
        while (test != 0) {
            int finTime = 240;
            int group = s.nextInt();
            int max = 0;
            while (group != 0) {
                int serv = s.nextInt();
                int c = s.nextInt();
                int part = serv+c;
                if(max < part){
                    max = part;
                }
                
                group--;
            }
            max +=10;
            int f = finTime - max;
            if(f >0){
                sb.append(f);
            }else{
                sb.append(0);
            }
            if(test ==1){
                
            }else{
                sb.append("\n");
            }
            test--;
        }
        System.out.println("-------------------------------");
        System.out.println(sb.toString());

    }
}
