package XMLsaxParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParserDemo {
    public static List<Student> group = new ArrayList<Student>();

    public static void main(String[] args) {
        try {
            File inputFile = new File("data.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            MyHandler myhandler = new MyHandler(group);
            saxParser.parse(inputFile, myhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < group.size(); i++) {
            System.out.println(group.get(i));
            System.out.println("Общий балл: " + Integer.toString(group.get(i).mathMark
                    + group.get(i).physicsMark + group.get(i).russianMark) + "\n");
        }
    }
}