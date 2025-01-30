package titanic2;
import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable>{
	public void reduce(Text key, Iterator<DoubleWritable> value, OutputCollector<Text, DoubleWritable> output, Reporter r) throws IOException{
		String keyStr = key.toString();
		if(keyStr.equals("male") || keyStr.equals("female")){
			double sum=0, count=0;
			while(value.hasNext()){
				sum += value.next().get();
				count++;
			}
			output.collect(new Text("Average age of " + keyStr), new DoubleWritable(sum/count));
		}
		else if(keyStr.startsWith("survivor")){
			double sum=0;
			while(value.hasNext()){
				sum += value.next().get();
			}
			output.collect(new Text(key), new DoubleWritable(sum));
		}
	}
}


