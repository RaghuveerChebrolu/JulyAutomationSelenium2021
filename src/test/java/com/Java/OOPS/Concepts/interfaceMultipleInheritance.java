package com.Java.OOPS.Concepts;

/*if a cass implements multiple interfaces, or an interface extends multiple interfaces, it is known as multiple inheritance*/

/*Q) Multiple inheritance is not supported through class in java, but it is possible by an interface, why?
As we have explained in the inheritance chapter, multiple inheritance is not supported in the case of class because 
of ambiguity. However, it is supported in case of an interface because there is no ambiguity. It is because its 
implementation is provided by the implementation class. For example:*/
interface Printable123{  
void print();  
}  
interface Showable{  
void print();  
}  
class interfaceMultipleInheritance implements Printable123,Showable{  
public void print(){System.out.println("Hello");}  
public void show(){System.out.println("Welcome");}  
  
public static void main(String args[]){  
	interfaceMultipleInheritance obj = new interfaceMultipleInheritance();  
obj.print();  
obj.show();  
 }  
}  