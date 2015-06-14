package hebb;

public class Neuron {
	Letter letter;
	int number;

	public Neuron(int size, String path, int number) {
		this.letter = new Letter(size);
		this.letter.readLetter(path);
		this.number = number;
	}
}
