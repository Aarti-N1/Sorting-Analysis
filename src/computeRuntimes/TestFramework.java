package computeRuntimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import sortAlgorithms.SortAlgorithms;

public class TestFramework {

    public final static int INPUT_SIZE = 0;
    public final static int INSERTION_SORT = 1;
    public final static int SELECTION_SORT = 2;
    public final static int MERGE_SORT = 3;
    public final static int BUBBLE_SORT = 4;


    public static void testBestCase(int range_start, int range_end, int range_increment, String caseType) {
        System.out.println("-----------------" + caseType + "-----------------");
        System.out.println("INPUT SIZE\tINSERTION SORT\tSELECTION SORT\tMERGE SORT\tBUBBLE SORT");
		
        int count = 0;
        long duration[][] = new long[100][5];
        long durationOfEachInstance[];
        long totalDurationOfRepeats[] = new long[5];
        
        for (int i = range_start; i<= range_end; i+=range_increment){
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 5 ; k++ )
                	totalDurationOfRepeats[k] = 0;
            
            for (int j = 0; j < 10; j++){
            	int [] inputNumbers = generateArrayOfRandomNumbers(i, 1);
                durationOfEachInstance = computeTimeOfRun(inputNumbers, false);
                
                for (int k = 0; k < 5; k++)
                	totalDurationOfRepeats[k] += durationOfEachInstance[k];
            }
            
            for (int k = 0; k < 5; k++)
                duration[count][k] = totalDurationOfRepeats[k] / 10;
            
            count++;
        }
        for (int i = 0; i < count; i++)
            System.out.println(duration[i][INPUT_SIZE]
                    + "\t" + duration[i][INSERTION_SORT]
                    + "\t" + duration[i][SELECTION_SORT]
                    + "\t" + duration[i][MERGE_SORT]
               		+ "\t" + duration[i][BUBBLE_SORT]);

        
        
        /*
		 * for (int i = range_start; i<= range_end; i+=range_increment){ int []
		 * inputNumbers = generateArrayOfRandomNumbers(i, 1);
		 * computeTimeOfRun(inputNumbers, true); }
		 */	}
	
	public static void testWorstCase(int range_start, int range_end, int range_increment, String caseType) {
        System.out.println("-----------------" + caseType + "-----------------");
        System.out.println("INPUT SIZE\tINSERTION SORT\tSELECTION SORT\tMERGE SORT\tBUBBLE SORT");
       
        int count = 0;
        long duration[][] = new long[100][5];
        long durationOfEachInstance[];
        long totalDurationOfRepeats[] = new long[5];
        
        for (int i = range_start; i<= range_end; i+=range_increment){
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 5 ; k++ )
                	totalDurationOfRepeats[k] = 0;
            
            for (int j = 0; j < 10; j++){
            	int [] inputNumbers = generateArrayOfRandomNumbers(i, -1);
                durationOfEachInstance = computeTimeOfRun(inputNumbers, false);
                
                for (int k = 0; k < 5; k++)
                	totalDurationOfRepeats[k] += durationOfEachInstance[k];
            }
            
            for (int k = 0; k < 5; k++)
                duration[count][k] = totalDurationOfRepeats[k] / 10;
            
            count++;
        }
        for (int i = 0; i < count; i++)
            System.out.println(duration[i][INPUT_SIZE]
                    + "\t" + duration[i][INSERTION_SORT]
                    + "\t" + duration[i][SELECTION_SORT]
                    + "\t" + duration[i][MERGE_SORT]
               		+ "\t" + duration[i][BUBBLE_SORT]);

        
		/*
		 * for (int i = range_start; i<= range_end; i+=range_increment){ int []
		 * inputNumbers = generateArrayOfRandomNumbers(i, -1);
		 * computeTimeOfRun(inputNumbers, true); }
		 */        
	}
	
	public static void testAverageCase(int range_start, int range_end, int range_increment, String caseType) {
        System.out.println("-----------------" + caseType + "-----------------");
        System.out.println("INPUT SIZE\tINSERTION SORT\tSELECTION SORT\tMERGE SORT\tBUBBLE SORT");
        int count = 0;
        long duration[][] = new long[100][5];
        long durationOfEachInstance[];
        long totalDurationOfRepeats[] = new long[5];
        
        for (int i = range_start; i<= range_end; i+=range_increment){
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 5 ; k++ )
                	totalDurationOfRepeats[k] = 0;
            
            for (int j = 0; j < 10; j++){
            	int [] inputNumbers = generateArrayOfRandomNumbers(i, -1);
                durationOfEachInstance = computeTimeOfRun(inputNumbers, false);
                
                for (int k = 0; k < 5; k++)
                	totalDurationOfRepeats[k] += durationOfEachInstance[k];
            }
            
            for (int k = 0; k < 5; k++)
                duration[count][k] = totalDurationOfRepeats[k] / 10;
            
            count++;
        }
        
        for (int i = 0; i < count; i++)
            System.out.println(duration[i][INPUT_SIZE]
                    + "\t" + duration[i][INSERTION_SORT]
                    + "\t" + duration[i][SELECTION_SORT]
                    + "\t" + duration[i][MERGE_SORT]
               		+ "\t" + duration[i][BUBBLE_SORT]);


	}
	
	public static long[] computeTimeOfRun(int[] inputNumbers, boolean isPrint) {
        long startTime;
        if (inputNumbers == null) 
        	return null;
        int size = inputNumbers.length;
        long duration[] = new long[5];
        duration[INPUT_SIZE] = size;
        int tmp [] = new int[size]; 

        for (int i = 0; i < size; i++)
            tmp[i] = inputNumbers[i];
        startTime = System.nanoTime();
        SortAlgorithms.insertionSort(tmp);
        duration[INSERTION_SORT] = System.nanoTime() - startTime;
        if (isPrint) System.out.print(duration[INPUT_SIZE] + "\t" + duration[INSERTION_SORT] + "\t");

        for (int i = 0; i < size; i++)
            tmp[i] = inputNumbers[i];
        startTime = System.nanoTime();
        SortAlgorithms.selectionSort(tmp);
        duration[SELECTION_SORT] = System.nanoTime() - startTime;
        if (isPrint) System.out.print(duration[SELECTION_SORT] + "\t");

        for (int i = 0; i < size; i++)
            tmp[i] = inputNumbers[i];
        startTime = System.nanoTime();
        SortAlgorithms.mergeSort(tmp, 0, size-1);
        duration[MERGE_SORT] = System.nanoTime() - startTime;
        if (isPrint) System.out.println(duration[MERGE_SORT] + "\t");
        
        for (int i = 0; i < size; i++)
            tmp[i] = inputNumbers[i];
        startTime = System.nanoTime();
        SortAlgorithms.bubbleSort(tmp);
        duration[BUBBLE_SORT] = System.nanoTime() - startTime;
        if (isPrint) System.out.println(duration[BUBBLE_SORT] + "\t");

        return duration;
    }
	
	/**
	 * @param size
	 * @param sortRequired :- 0 - No sort required; 1 - Sort required; -1 - Reverse sorted input required
	 * @return int array
	 */
	public static int[] generateArrayOfRandomNumbers(int size, int sortRequired) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Random randomNumber = new Random();
		for (int i = 0; i < size ; i++) {
			al.add(randomNumber.nextInt(size));
		}
		if(sortRequired==1) {
			Collections.sort(al);
		}else if(sortRequired==-1) {
			Collections.sort(al, Collections.reverseOrder());
		}
		int [] randomList =  new int[al.size()];
        for(int i = 0; i < al.size(); i++) {
            if (al.get(i) != null) {
                randomList[i] = al.get(i);
            }
        }
        return randomList;
		
	}
	
	public static void main(String[] args) {
		testBestCase(100, 10000, 100, "[BEST CASE]");
		testWorstCase(100, 10000, 100, "[WORST CASE]");
		testAverageCase(100, 10000, 100, "[AVERAGE CASE]");
	}

}
