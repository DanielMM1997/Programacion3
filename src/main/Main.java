package main;

import linearequation.SLE_BacktrackingIterative;
import linearequation.SLE_BruteForceIterative;
import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) {

        Options options = new Options();

        Option help = new Option("h", "help", false, "show help message");
        options.addOption(help);
        Option cmd_f = new Option("f", "file", true, "input data from a file");
        cmd_f.setArgName("filename");
        options.addOption(cmd_f);
        Option cmd_dt = new Option("dt", "time", false, "Display time in seconds");
        options.addOption(cmd_dt);
        Option cmd_do = new Option("do", "time", false, "Display time in seconds");
        options.addOption(cmd_do);
        Option cmd_bf = new Option("bf", "Brute force iterative");
        options.addOption(cmd_bf);
        Option cmd_bt = new Option("bt", "Backtracking iterative");
        options.addOption(cmd_bt);
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        
        long inicio = 0;
        long fin = 0;
        int[] coeff = null;
        int rhs = 0;
        int min = 0;
        
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("help") || cmd.hasOption("h")) {
                String head = "\nSysntax: -f test1.txt -bf -bt -dt -do";
                formatter.printHelp("Options:", "", options, head, true);
                System.exit(0);
            }
            if (cmd.hasOption("f")) {
                InputData input = new InputData();
                coeff = input.readFile(cmd.getOptionValue("f"));  
                rhs = input.rhs;
                min = coeff[0];
                for (int i = 0; i < coeff.length; i++) {
                    if(min > coeff[i]) {
                        min = coeff[i];
                    }                    
                }
            }
            if (cmd.hasOption("bf")){
                SLE_BruteForceIterative bfi = new SLE_BruteForceIterative(coeff.length, 0, rhs/min);                
                inicio = System.currentTimeMillis();
                int sol = bfi.count(coeff, rhs);
                fin = System.currentTimeMillis();
                if (cmd.hasOption("do")) {
                    System.out.println("Total number of solutions are in BF: " + sol);
                }                
                if (cmd.hasOption("dt")){
                    double tiempo = (double) (fin - inicio)/1000;  
                    System.out.println("BruteForeceIterative: " + tiempo + " seconds");
                }                
            }
            if (cmd.hasOption("bt")){
                SLE_BacktrackingIterative bti = new SLE_BacktrackingIterative(coeff, 0, rhs/min, rhs);
                inicio = System.currentTimeMillis();
                int sol = bti.count(coeff, rhs);
                fin = System.currentTimeMillis();
                if (cmd.hasOption("do")) {
                    System.out.println("Total number of solutions are in BT: " + sol);
                } 
                if (cmd.hasOption("dt")){
                    double tiempo = (double) (fin - inicio)/1000;  
                    System.out.println("BactrackingRecursive: " + tiempo + " seconds");
                }
            }
            
        } catch (ParseException e) {
            System.out.println("Parsing failed. Reason: " + e.getMessage());
            formatter.printHelp("utility-name", options, true);
            System.exit(1);
        }
    }    
}
