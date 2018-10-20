package XMLsaxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public class MyHandler extends DefaultHandler {

    boolean bFirstName = false;
    boolean bLastName = false;
    boolean bmath = false;
    boolean bphysics = false;
    boolean brussian = false;
    boolean bform = false;

    String firstName;
    String lastName;
    String math;
    String physics;
    String russian;
    String groupNo;
    String form;
    List<Student> group;

    MyHandler(List<Student> group) {
        super();
        this.group = group;
    }

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("student")) {
            groupNo = attributes.getValue("groupno");
        }
        if (qName.equalsIgnoreCase("firstname")) {
            bFirstName = true;
        }
        if (qName.equalsIgnoreCase("lastname")) {
            bLastName = true;
        }
        if (qName.equalsIgnoreCase("learningForm")) {
            bform = true;
        }
        if (qName.equalsIgnoreCase("math")) {
            bmath = true;
        }
        if (qName.equalsIgnoreCase("physics")) {
            bphysics = true;
        }
        if (qName.equalsIgnoreCase("russian")) {
            brussian = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("student")) {
            Student s = new Student();
            try {
                s.id = Integer.parseInt(groupNo);
                s.firstname = firstName;
                s.lastname = lastName;
                if (form.equalsIgnoreCase("b")) {
                    s.form = true;
                } else {
                    s.form = false;
                }
                s.mathMark = Integer.parseInt(math);
                s.physicsMark = Integer.parseInt(physics);
                s.russianMark = Integer.parseInt(russian);
            }
            catch (Exception e) {
                System.out.println("Can't create student №" + groupNo);
            }
            group.add(s);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bFirstName) {
            firstName = new String(ch, start, length);
            bFirstName = false;
        } else if (bLastName) {
            lastName =  new String(ch, start, length);
            bLastName = false;
        } else if (bmath) {
            math = new String(ch, start, length);
            bmath = false;
        } else if (bphysics) {
            physics = new String(ch, start, length);
            bphysics = false;
        } else if (brussian) {
            russian = new String(ch, start, length);
            brussian = false;
        } else if (bform) {
            form = new String(ch, start, length);
            bform = false;
        }
    }
}