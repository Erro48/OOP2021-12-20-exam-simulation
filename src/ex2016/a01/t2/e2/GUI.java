package ex2016.a01.t2.e2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.*;

public class GUI {
    
    public GUI(String fileName){
    	Logic logic = new Logic();
        JFrame jf = new JFrame();
        JButton jbinc = new JButton("INCINC");
        JButton jbrand = new JButton("RAND");
        JButton jbone = new JButton("UNO");
        JButton jbOK = new JButton("OK");
        jbinc.addActionListener(e -> logic.inc());
        jbrand.addActionListener(e -> logic.rand());
        jbone.addActionListener(e -> logic.one());
        jbOK.addActionListener(e -> {
			try {
				logic.compute(System.out, new PrintStream(new File(fileName)));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
        JPanel jp = new JPanel();
        jp.add(jbinc);
        jp.add(jbrand);
        jp.add(jbone);
        jp.add(jbOK);
        jf.getContentPane().add(jp);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

}
