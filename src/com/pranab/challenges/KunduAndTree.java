package com.pranab.challenges;

import java.io.*;
import java.util.*;

public class KunduAndTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n + 1];
        for(int i = 1; i <= n; i++){
            nodes[i] = new Node();
        }
        for(int i = 1; i < n; i++){
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            String c = sc.next();
            if(c.equals("b")){
                merge(nodes[i1], nodes[i2]);
            }
        }
        
        long sum = (long)n * (n - 1) * (n - 2) / 6;
        for(int i = 1; i <= n; i++){
            Node r = nodes[i].getRoot();
            if(r.size == 1) continue;
            if(r.seen) continue;
            r.seen = true;
            
            sum -= (long)r.size * (r.size - 1) * (r.size - 2) / 6;
            sum -= (long)r.size * (r.size - 1) / 2 * (n - r.size);
        }
        
        System.out.println(sum % 1000000007);
        
    }
    
    
    static void merge(Node n1, Node n2){
        Node r1 = n1.getRoot();
        Node r2 = n2.getRoot();
        if(r1 == r2) return;
        if(r1.size > r2.size){
            r1.size += r2.size;
            r2.parent = r1;
        } else {
            r2.size += r1.size;
            r1.parent = r2;
        }
    }
    
    static class Node{
        
        Node(){
            size = 1;
        }
        
        boolean seen;
        int size;
        Node parent;
        
        Node getRoot(){
            Node r = this;
            while(r.parent != null) r = r.parent;
            return r;
        }
        
    }
}