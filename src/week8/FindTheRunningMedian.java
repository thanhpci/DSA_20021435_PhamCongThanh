package week8;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class FindTheRunningMedian {
    class Result {

        /*
         * Complete the 'runningMedian' function below.
         *
         * The function is expected to return a DOUBLE_ARRAY.
         * The function accepts INTEGER_ARRAY a as parameter.
         */

        public static List<Double> runningMedian(List<Integer> a) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            List<Double> result = new ArrayList<>();

            for (int i = 0; i < a.size(); ++i) {
                double addResult = 0;
                int v = a.get(i);
                if (maxHeap.isEmpty() || (v < maxHeap.peek())) {
                    maxHeap.offer(v);
                } else {
                    minHeap.offer(v);
                }

                if (maxHeap.size() > (minHeap.size() + 1)) {
                    minHeap.offer(maxHeap.poll());
                }

                if (minHeap.size() > (maxHeap.size() + 1)) {
                    maxHeap.offer(minHeap.poll());
                }

                if (maxHeap.size() > minHeap.size()) {
                    addResult = maxHeap.peek();
                    result.add(addResult);
                } else if (minHeap.size() > maxHeap.size()) {
                    addResult = minHeap.peek();
                    result.add(addResult);
                } else {
                    addResult = 0.5 * (minHeap.peek() + maxHeap.peek());
                    result.add(addResult);
                }
            }

            return result;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int aCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Double> result = Result.runningMedian(a);

            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
