package wordcount2;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
	IntWritable one = new IntWritable(1);
	Text word = new Text();
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter r) throws IOException{
		String[] line = value.toString().split(" ");
		for(String i: line){
			word.set(i);
			output.collect(word, one);
		}
	}
}
