package training.maventest.project1;

import java.io.FileWriter;
import java.io.IOException;

import training.maventest.project1.jsontest.simplejson.QueryAttribute;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		QueryAttribute qa = new QueryAttribute("English", 100);
		try {
			FileWriter fw = new FileWriter("tmpfle.log");
			qa.writeJSONString(fw);
			fw.close();
		} catch (IOException e) {
			java.lang.System.out.println("err");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
