package com.nt.generator;


public class RandomStringGenerator { 
  public static void main(String[] args) { 
    String randomString = usingMath(); 
    System.out.println("Random string is: " + randomString); 
  } 

  static String usingMath() { 
    String alphabetsInUpperCase = "NIT"; 
    String numbers = "0123456789"; 
    // create a super set of all characters 
    String allCharacters = alphabetsInUpperCase + numbers; 
    // initialize a string to hold result 
    StringBuffer randomString = new StringBuffer(); 
    // loop for 10 times 
    for (int i = 0; i < 10; i++) { 
      // generate a random number between 0 and length of all characters 
      int randomIndex = (int)(Math.random() * allCharacters.length()); 
      // retrieve character at index and add it to result 
      randomString.append(allCharacters.charAt(randomIndex)); 
    } 
    return randomString.toString(); 
  } 
}