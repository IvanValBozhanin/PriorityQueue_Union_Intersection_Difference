package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        String [] s1 = { "George" , "Jim" , "John" , "Blake" , "Kevin" , "Michael"};
        String [] s2 = { "George" , "Katie" , "Kevin" , "Michelle" , "Ryan"};

        printUnion(s1, s2);
        printIntersection(s1, s2);
        printDifference(s1, s2);
    }

    public static void printDifference(String [] s1, String[] s2){
        PriorityQueue<String> a = new PriorityQueue<>(Arrays.asList(s1));
        PriorityQueue<String> b = new PriorityQueue<>(Arrays.asList(s2));
        System.out.print("Difference is: ");
        while(!a.isEmpty() || !b.isEmpty()){
            if(a.isEmpty()){
                System.out.print(b.poll() + ", ");
            }
            else if(b.isEmpty()){
                System.out.print(a.poll() + ", ");
            }
            else if(a.peek().compareTo(b.peek()) < 0){
                System.out.print(a.poll() + ", ");
            }
            else if(a.peek().compareTo(b.peek()) > 0){
                System.out.print(b.poll() + ", ");
            }
            else{
                a.poll();
                b.poll();
            }
        }
        System.out.println("\b\b");
    }

    public static void printIntersection(String [] s1, String [] s2){
        PriorityQueue<String> a = new PriorityQueue<>(Arrays.asList(s1));
        PriorityQueue<String> b = new PriorityQueue<>(Arrays.asList(s2));

        System.out.print("Intersection is: ");
        while(!a.isEmpty() && !b.isEmpty()){
            if(a.peek().compareTo(b.peek()) < 0){
                a.poll();
            }
            else if(b.peek().compareTo(a.peek()) < 0){
                b.poll();
            }
            else {
                System.out.print(a.poll() + ", ");
                b.poll();
            }
        }
        System.out.println("\b\b");
    }

    public static void printUnion(String [] s1, String [] s2){
        PriorityQueue<String> a = new PriorityQueue<>(Arrays.asList(s1));
        PriorityQueue<String> b = new PriorityQueue<>(Arrays.asList(s2));

        System.out.print("Union is: ");
        while(!a.isEmpty() || !b.isEmpty()){
            if(a.isEmpty()){
                System.out.print(b.poll() + ", ");
            }
            else if(b.isEmpty()){
                System.out.print(a.poll() + ", ");
            }
            else if(a.peek().compareTo(b.peek()) < 0){
                System.out.print(a.poll() + ", ");
            }
            else if(a.peek().compareTo(b.peek()) > 0){
                System.out.print(b.poll() + ", ");
            }
            else{
                System.out.print(a.poll() + ", ");
                b.poll();
            }
        }
        System.out.println("\b\b");
    }
}
