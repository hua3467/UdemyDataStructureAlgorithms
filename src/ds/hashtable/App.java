/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.hashtable;

/**
 *
 * @author aaronyang
 */
public class App {
    public static void main(String[] args) {
        
        HashTable table = new HashTable(24);
        table.insert("Apple");
        table.insert("Hello");
        table.insert("Feeling");
        table.insert("Water");
        table.insert("Africa");
        table.insert("Speed");
        table.insert("Phone");
        table.insert("September");
        table.insert("Michael");
        table.insert("Milk");
        table.insert("Huge");
        table.insert("Dogs");
        
        table.displayATable();
        
//        System.out.println("-----------FIND ELEMENTS-------------");
//        System.out.println(table.find("Apple"));
//        System.out.println(table.find("Zebra"));
//        System.out.println(table.find("Feeling"));
//        System.out.println(table.find("Water"));
//        System.out.println(table.find("Africa"));
//        System.out.println(table.find("Feeling"));
    }
}
