package solver;
/*
 * Created by Richard Harrington
 * November 3, 2014
 * Finds the longest series of elements such that the values of the elements summed by
 * character are each greater than 0
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solver{

	
	class Element{
		String letter;
		int value;
	}

	private int tests, lines;
    ArrayList<Element> elements = new ArrayList<Element>();

    public void solve() throws IOException {
        try {
            // Open input and output files
            BufferedReader in = new BufferedReader(new FileReader(this.getClass().getResource("input.txt").getFile()));

            File f = new File(this.getClass().getResource("output.txt").getFile());
            if(!f.exists()){
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f);
            BufferedWriter out = new BufferedWriter(fw);

            // Read in the number of test cases
            tests = Integer.parseInt(in.readLine());

            for(int i=0;i<tests;i++){

                // read in the number of lines in the case
                lines = Integer.parseInt(in.readLine());

                for(int j=0;j<lines;j++){
                    // read each line into an element and add it to the array
                    String[] line= in.readLine().split(":");
                    Element e = new Element();
                    e.letter = line[0];
                    e.value = Integer.parseInt(line[1].trim());
                    elements.add(e);
                }

                // Process the array
                System.out.println("Working on test case: "+ (i+1));
                boolean found = false;
                for(int k=elements.size();k>0;k--){
                    // Working from the max size of the list down

                    // Initialize variables, and if the test has been solved, exit the test
                    int position = 0;
                    int sumA = 0, sumB = 0, sumC = 0;
                    if(found) break;


                    while(k+position<=elements.size()&& !found) {
                        // For each subset of length 'k' starting at position 'position',
                        // sum the values in the subset
                        List<Element> testList = elements.subList(position, k+position);
                        for(Element elem:testList){
                            if(elem.letter.equalsIgnoreCase("a")) sumA+=elem.value;
                            else if(elem.letter.equalsIgnoreCase("b")) sumB+=elem.value;
                            else if(elem.letter.equalsIgnoreCase("c")) sumC+=elem.value;
                        }


                        if(sumA>0 && sumB>0 && sumC>0){
                            // We have a winner! write the information to file
                            out.write("Length: "+k);
                            out.newLine();
                            for(Element elem:testList){
                                out.write(elem.letter+": "+elem.value);
                                out.newLine();
                            }
                            out.write("A: "+sumA+" B: "+sumB+" C: "+sumC);
                            out.newLine();
                            out.flush();
                            found = true;
                        } else {
                            // increment, reset, and move on
                            position++;
                            sumA = 0;
                            sumB = 0;
                            sumC = 0;
                        }
                    }
                }
                // Clear the elements to prepare for the next test case
                elements.clear();
            }

            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            // Oops! Something went wrong
            System.out.println("Input file not found.");
            return;
        }

    }

}
