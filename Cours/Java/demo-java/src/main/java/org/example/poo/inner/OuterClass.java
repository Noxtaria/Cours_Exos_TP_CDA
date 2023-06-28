package org.example.poo.inner;

public class OuterClass {


    private static String message = "Dans une classe externe ";


    public static class AutreClassInner {
        public void afficheMessage(){

            System.out.println("Je suis une class inerne statique " + message);
        }
    }


    public class InnerClass{

        public void afficheMessage(){
            System.out.println("Je suis une class inerne non statique " + message);
        }


    }















}
