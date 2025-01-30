package oddeven2;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter r) throws IOException{
		String[] line = value.toString().split(" ");
		for(String i: line){
			int num = Integer.parseInt(i);
			if(num % 2 == 0)
				output.collect(new Text("even"), new IntWritable(num));
			else
				output.collect(new Text("odd"), new IntWritable(num));
		}
	}
}
