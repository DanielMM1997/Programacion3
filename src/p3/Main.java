package p3;

import MatrixChainMultiplication.*;
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
        Option cmd_a = new Option("r", "Brute force recursive");
        options.addOption(cmd_a);
        Option cmd_c = new Option("m", "Memoization");
        options.addOption(cmd_c);
        Option cmd_d = new Option("t", "Tabulation");
        options.addOption(cmd_d);
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        
        long inicio = 0;
        long fin = 0;
        int[] data = null;
        
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("help") || cmd.hasOption("h")) {
                String head = "\nSysntax: -f test1.txt -r -m -t -dt -do";
                formatter.printHelp("Options:", "", options, head, true);
                System.exit(0);
            }
            if (cmd.hasOption("f")) {
                InputData input = new InputData();
                data = input.readFile(cmd.getOptionValue("f"));  
            }
            if (cmd.hasOption("r")){
                MCM_BruteForceRecursive bfr = new MCM_BruteForceRecursive();                
                inicio = System.currentTimeMillis();
                int sol = bfr.MatrixChainMultiplication(data, 0, data.length-2);
                fin = System.currentTimeMillis();
                if (cmd.hasOption("do")){
                    System.out.println("Minimun Cost in BruteForceRecursive: " + sol);
                }
                if (cmd.hasOption("dt")){
                    double tiempo = (double) (fin - inicio)/1000;  
                    System.out.println("BruteForceRecursive: " + tiempo + " seconds");
                }
            }
            if (cmd.hasOption("m")){
                MCM_Memoization mem = new MCM_Memoization();                
                inicio = System.currentTimeMillis();
                int sol = mem.MatrixChainMultiplication(data, 0, data.length-2);
                fin = System.currentTimeMillis();
                if (cmd.hasOption("do")){
                    System.out.println("Minimun Cost in Memoization: " + sol);
                }
                if (cmd.hasOption("dt")){
                    double tiempo = (double) (fin - inicio)/1000;  
                    System.out.println("Memoization: " + tiempo + " seconds");
                }
            }
            if (cmd.hasOption("t")) {
                MCM_Tabulation tab = new MCM_Tabulation();
                inicio = System.currentTimeMillis();
                int sol = tab.tabulation(data, 0, data.length-2);
                fin = System.currentTimeMillis();
                if (cmd.hasOption("do")){
                    System.out.println("Minimun Cost in Tabulation: " + sol);
                }
                if (cmd.hasOption("dt")){
                    double tiempo = (double) (fin - inicio)/1000;  
                    System.out.println("Tabulation: " + tiempo + " seconds");
                }
            }            
        } catch (ParseException e) {
            System.out.println("Parsing failed. Reason: " + e.getMessage());
            formatter.printHelp("utility-name", options, true);
            System.exit(1);
        }
    }    
}
