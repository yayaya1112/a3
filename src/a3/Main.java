package a3;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    /**
     * Replace "-1" by the time you spent on A3 in hours.
     * Example: for 3 hours 15 minutes, use 3.25
     * Example: for 4 hours 30 minutes, use 4.50
     * Example: for 5 hours, use 5 or 5.0
     */
    public static double timeSpent = 10;


    /* TODO 6
     * Write a function that takes in a csv file name as a string and returns a Linked List
     * representation of the CSV table.
     */
    public static LList<LList<String>> csvToList(String name){
        String path = name;
        try {
            Reader in = new FileReader(path);
            BufferedReader br = new BufferedReader(in);
            String line = br.readLine();

            while(line != null) {
                System.out.println(line);
                line = br.readLine();
            }

            LList<String> inner = new SLinkedList<String>();
            LList<LList<String>> outer= new SLinkedList<LList<String>>();
            for (int i=0; i<line.length(); i++) {
                    //split to individual words
                    String[] tokens = line.split(", ");
                    for (int j=0; j<tokens.length; j++) {
                        inner.append(tokens[j]);
            }
                    outer.append(inner); //change

            }
            return outer;

        } catch (FileNotFoundException var6) {
            System.err.println("Could no open file " + path);
            System.exit(1);
        } catch (IOException var7) {
            System.err.println("Error reading file " + path);
            System.exit(1);
        }

        //split it again with ', '
        return null;

    }


    /* TODO 7
     * Write a function that takes in two lists representing tables and
     * computes their left join.
     */
    public static LList<LList<String>> join(LList<LList<String>> table1,
                                            LList<LList<String>> table2) {
        String path = table1, table2;
        l1=table1[0];
        l2=table2[0];
        SLinkedList newList= new SLinkedList();
        while (table1!=null && table2!=null) {
            //if table1 equals table 2
            if (l1==l2) {
                newList.append(l1);
                newList.append(l2);
                l1=l1.next;
                l2=l2.next;
            }
            //if l1 is smaller, append lower and advance lower
            if (l1<l2) {
                newList.append(l1);
                l1=l1.next;
            }

            else{
                newList.append(l2);
                l2=l2.next;
            }
        }

        return new SLinkedList<>();
    }

    /** Effect: Print a usage message to standard error. */
    public static void usage() {
        System.err.println("Usage: a3.Main <file1.csv> <file2.csv>");
    }



    public static void main(String[] arg) throws FileNotFoundException{
        //pass the file name? command line arguments
    }
    /* TODO 8
     * Write the main method, which parses the command line arguments, reads CSV files
     * into tables, and prints out the resulting table resulting from a left join of the
     * input tables. Hint: use helper methods.
     */
}
