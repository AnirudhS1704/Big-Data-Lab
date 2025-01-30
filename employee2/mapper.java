package employee2;
import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable>{
	public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter r) throws IOException{
		String[] line = value.toString().split(",");

		if(line.length < 5)
			return;
		String gender = line[3];
		double salary = Double.parseDouble(line[4]);
		
		output.collect(new Text(gender), new DoubleWritable(salary));
	}
}
