package hebb;

public class Network {
	Neuron x1 = new Neuron(5, "D:\\C.txt", 1);
	Neuron x2 = new Neuron(5, "D:\\K.txt", -1);

	/**
	 * ���� ������.
	 */ 
	int[] w = new int[x1.letter.makeOneDimensional().length + 1];

	public Network() {
		super();
		x1.letter.show();
		x2.letter.show();
	}

	/**
	 * ������������� ����� ������ �������.
	 * 
	 * @param neuron
	 *            ���� �������� ������ � �����.
	 */
	public void learn(Neuron neuron) {
		int x = 1;
		w[0] += x * neuron.number;
		for (int i = 1; i <= neuron.letter.makeOneDimensional().length; i++) {
			w[i] += neuron.letter.makeOneDimensional()[i - 1] * neuron.number;
		}
	}

	/**
	 * �������� �������.
	 */
	public void training() {
		do {
			learn(x1);
			for (int i = 0; i < w.length; i++)
				System.out.print(w[i] + "\t");
			System.out.println();
			learn(x2);
			for (int i = 0; i < w.length; i++)
				System.out.print(w[i] + "\t");
		} while (stopCkeck(x1) != true & stopCkeck(x2) != false);
	}

	/**
	 * �������� ������� ��������.
	 * 
	 * @param n
	 *            - ���� ��������.
	 * @return
	 */
	boolean stopCkeck(Neuron n) {
		int sum = 0;
		for (int i = 1; i <= n.letter.makeOneDimensional().length; i++)
			sum += w[i] * n.letter.makeOneDimensional()[i - 1];
		sum += w[0];
		if (sum > 1)
			return true;
		return false;
	}

	/**
	 * ������������� �����������.
	 * 
	 * @param n
	 *            - �����������.
	 */
	public void recognition(Neuron n) {
		int sum = 0;
		for (int i = 1; i <= n.letter.makeOneDimensional().length; i++)
			sum += n.letter.makeOneDimensional()[i - 1] * w[i];
		sum += w[0];
		if (sum > 1)
			System.out.println("\n��� ������ �����������!");
		else
			System.out.println("\n��� ������ �����������!");
	}
}
