package com.pranab.challenges;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
class Result96 {

	static class WaitingNode{
		long startTime=0;
		long pizzaTime=0;
		long totalTime=0;
		public WaitingNode(long startTime, long pizzaTime) {
			super();
			this.startTime = startTime;
			this.pizzaTime = pizzaTime;
			this.totalTime = startTime+pizzaTime;
		}
		
	}
	public static List<WaitingNode> STORAGE=new ArrayList<Result96.WaitingNode>();

	public static int getParentIndex(int childInedx) {
		return (childInedx - 1) >> 1;
	}

	public static int getLeftChild(int index) {
		return (index << 1) + 1;
	}

	public static int getRightChild(int index) {
		return (index << 1) + 2;
	}

	public static void minifyHeap(int index) {
		int leftChildIndex = getLeftChild(index);
		int rightChildIndex = getRightChild(index);
		int smallest = index;
		long lastIndex = STORAGE.size();
		if (leftChildIndex < lastIndex && STORAGE.get(leftChildIndex).totalTime < STORAGE.get(index).totalTime) {
			smallest = leftChildIndex;
		}
		if (rightChildIndex < lastIndex && STORAGE.get(rightChildIndex).totalTime < STORAGE.get(smallest).totalTime) {
			smallest = rightChildIndex;
		}
		if (smallest != index) {
			exchange(index, smallest);
			minifyHeap(smallest);
		}
	}

	private static void exchange(int index, int otherIndex) {
		WaitingNode temp = STORAGE.get(index);
		STORAGE.set(index, STORAGE.get(otherIndex));
		STORAGE.set(otherIndex, temp);
	}

	private static void add(WaitingNode value) {
		STORAGE.add(value);
		int index = STORAGE.size() - 1;
		int parentIndex = getParentIndex(index);
		while (index > 0 && STORAGE.get(index).totalTime < STORAGE.get(parentIndex).totalTime) {
			exchange(index, parentIndex);
			index = parentIndex;
			parentIndex = getParentIndex(index);
		}
	}

	private static WaitingNode extractMin() {
		WaitingNode minElement = STORAGE.get(0);
		exchange(0, STORAGE.size() - 1);
		STORAGE.remove(STORAGE.size() - 1);
		minifyHeap(0);
		return minElement;
	}
	
	public static long minimumAverage(List<List<Integer>> customers) {
		int minTime=Integer.MAX_VALUE; int minPizzaTime=0;
		for(List<Integer> customer:customers) {
			if(customer.get(0)<minTime) {
				minTime=customer.get(0);
				minPizzaTime=customer.get(1);
			}
		}
		for(List<Integer> customer:customers) {
			customer.set(0, (customer.get(0)-minTime));
		}
	    for(List<Integer> customer:customers) {
	    	WaitingNode node=new WaitingNode(customer.get(0),customer.get(1));
	    	add(node);
	    }
	    WaitingNode waitNode=extractMin();
	    long prevtotal=waitNode.pizzaTime;
	    long totalTime=waitNode.pizzaTime;
	    while(!STORAGE.isEmpty()) {
	    	waitNode=extractMin();
	    	prevtotal=prevtotal+waitNode.pizzaTime;
	    	totalTime+=(prevtotal-waitNode.startTime);
	    }
		return totalTime/(customers.size());
	    }
}


public class MinimumAverageWaiting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> customers = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                customers.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result96.minimumAverage(customers);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}