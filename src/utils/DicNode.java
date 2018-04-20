/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author William Barbosa
 */
public class DicNode {

    public int value;
    public DicNode[] root;

    public DicNode(int v) {
        value = v;
        root = new DicNode[26];
    }

    public static void buildBannedDic(String[] banWords, DicNode root) {
        DicNode cur = root;
        for (String s : banWords) {
            for (int i = 0; i < s.length(); i++) {
                char letter = s.charAt(i);
                int index = letter > 'Z' ? (letter - 'a') : (letter - 'A');
                if (i == s.length() - 1) {
                    if (cur.root[index] == null) {
                        cur.root[index] = new DicNode(-1);
                    } else {
                        cur.root[index].value = -1;
                    }
                } else {
                    if (cur.root[index] == null) {
                        cur.root[index] = new DicNode(0);
                    }
                    cur = cur.root[index];
                }
            }
            cur = root;
        }
    }

}
