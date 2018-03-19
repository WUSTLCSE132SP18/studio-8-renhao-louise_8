package studio8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.sun.xml.internal.messaging.saaj.soap.StringDataContentHandler;

import javafx.scene.chart.PieChart.Data;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.
public class CountSteps{
	public static void main(String args[]) throws FileNotFoundException{
		List<Entry> steps = new LinkedList<>();
		File data = new File("data.csv");
		Scanner scanner = new Scanner(data);
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] xyz = line.split(",");
			double x = Double.parseDouble(xyz[0]);
			double y = Double.parseDouble(xyz[1]);
			double z = Double.parseDouble(xyz[2]);
			Entry entry = new Entry(x, y, z);
			steps.add(entry);
		}
		double ax=0;
		double ay = 0;
		double az =0;
		for(Entry entry :steps) {
			ax += entry.x;
			ay += entry.y;
			az += entry.z;
		}
		ax /=steps.size();
		ay/=steps.size();
		az/= steps.size();
		Entry average = new Entry(ax, ay, az);
		int Count = 0;
		Entry[] stepArray = new Entry[steps.size()];
		steps.toArray(stepArray);
		for(int i = 1; i< stepArray.length-1;i++) {
			if (stepArray[i].scale(stepArray[i-1])>3&&stepArray[i].scale(stepArray[i+1])>3) {
				Count++;
			}
		}
		System.out.println(Count);
	}
}