package com.example.BookShop.Exceptions;

 public class Notfounded extends RuntimeException{
     public Notfounded() {
         super();
     }
     public Notfounded(String message) {
         super(message);
     }
 }
