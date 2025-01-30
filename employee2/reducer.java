package employee2;
import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable>{
	public void reduce(Text key, Iterator<DoubleWritable> value, OutputCollector<Text, DoubleWritable> output, Reporter r) throws IOException{
		double sum=0, count=0;
		while(value.hasNext()){
			sum += value.next().get();
			count++;
		}

		output.collect(new Text(key + " count: "), new DoubleWritable(count));
		output.collect(new Text(key + " average: "), new DoubleWritable(sum/count));
	}
}


