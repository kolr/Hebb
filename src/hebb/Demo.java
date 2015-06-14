package hebb;

import javax.swing.*;

public class Demo {
	public static void main(String[] args) {
		Network n = new Network();
		Neuron part = new Neuron(5, "D:\\C1.txt", 2);
		part.letter.show();
		n.training();
		n.recognition(part);
	}
}
