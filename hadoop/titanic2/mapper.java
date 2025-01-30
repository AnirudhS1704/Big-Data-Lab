package titanic2;
import java.io.*;
import java.util.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable>{
	public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter r) throws IOException{
		String[] line = value.toString().split(",");

		if(line.length < 9)
			return;
		int survived = Integer.parseInt(line[1].trim());
		String gender = line[4];
		double age = Double.parseDouble(line[5]);
		int pclass = Integer.parseInt(line[2]);
		
		if(survived == 0)
			output.collect(new Text(gender), new DoubleWritable(age));
		else
			output.collect(new Text("survivor_"+pclass), new DoubleWritable(1));
	}
}
