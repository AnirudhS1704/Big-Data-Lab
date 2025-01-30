package wordcount2;
import java.util.*;
import java.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.Path;

public class driver{
	public static void main(String arg[]) throws IOException{
		JobConf conf = new JobConf(driver.class);
		conf.setMapperClass(mapper.class);
		conf.setReducerClass(reducer.class);

		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(conf, new Path(arg[0]));
		FileOutputFormat.setOutputPath(conf, new Path(arg[1]));

		JobClient.runJob(conf);
	}
}
