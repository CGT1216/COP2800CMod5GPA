// PalmerPenguinsM5.java
// Christin George Thomas
// 10/04/2026
// Reads the CSV file and parses the data into arrays
import java.io.*;
import java.util.*;

public class PalmerPenguinsM5 {

    static final String FILE_NAME = "PalmerPenguins.csv";
    
    public static final int NUM_SPECIES = 3;
    public static final String SP_CHINSTRAP = "Chinstrap";
    public static final String SP_GENTOO = "Gentoo";
    public static final String SP_ADELIE = "Adelie";
    
    public static void main(String[] args) {
    
        final int SP_CHINSTRAP_INDEX = 0;
        final int SP_GENTOO_INDEX = 1;
        final int SP_ADELIE_INDEX = 2;
    
        String[] speciesData = CSVReader.readFile(FILE_NAME, 1);
        
        int[] speciesCount = new int[NUM_SPECIES];

        if (speciesData.length == 0) {
            System.out.println("Error: The file is empty or could not be read.");
            return;
        }

        for (String species : speciesData) {
            if (species.equals(SP_CHINSTRAP)) {
                speciesCount[SP_CHINSTRAP_INDEX]++;
            } else if (species.equals(SP_GENTOO)) {
                speciesCount[SP_GENTOO_INDEX]++;
            } else if (species.equals(SP_ADELIE)) {
                speciesCount[SP_ADELIE_INDEX]++;
            }
        }
    
        System.out.println(SP_CHINSTRAP + " count = " + speciesCount[SP_CHINSTRAP_INDEX]);
        System.out.println(SP_GENTOO + " count = " + speciesCount[SP_GENTOO_INDEX]);
        System.out.println(SP_ADELIE + " count = " + speciesCount[SP_ADELIE_INDEX]);

    }
}

class CSVReader {
     public static String[] readFile(String FILE_NAME, int column) {
        List<String> columnValues = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                
                if (column >= 0 && column < tokens.length) {
                    columnValues.add(tokens[column]);
                } else {
                    columnValues.add("");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
        
        return columnValues.toArray(new String[0]);
    }
}