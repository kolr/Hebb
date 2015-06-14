package hebb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Letter {
	/**
	 * ���������� ������ � ���� �������� ���������� �����������.
	 */
	private static int counter = 0;
	/**
	 * ������ �������. ������� - ����������, ������� �������� ������� ��������
	 * ����� ����������.
	 */
	static int size;
	/**
	 * ������� �������� �����������.
	 */
	private int[][] picturePixels;

	/**
	 * ����������� �������������� �������� ������� � ������� �������.
	 * 
	 * @param size
	 *            - ������ �������
	 */
	public Letter(int size) {
		super();
		this.size = size;
		picturePixels = new int[size][size];
		counter++;
	}

	/**
	 * ����� ��������� �������� �������� ������� �������� ����������� ��������
	 * �������.
	 * 
	 * @return - ������� �����������.
	 */
	public int[][] getPicturePixels() {
		return picturePixels;
	}

	/**
	 * ������ ������� �� �����.
	 * 
	 * @param aFilePath
	 *            - ���� � �����
	 */
	public void readLetter(String aFilePath) {
		File file = new File(aFilePath);
		BufferedReader in;
		String iRecord;
		int iCounter = 0;
		try {
			in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
			try {
				while (true) {
					iRecord = in.readLine();
					if (iRecord == null) {
						break;
					} else {
						for (int i = 0; i < iRecord.length(); i++)
							picturePixels[iCounter][i] = returnCharValue(
									iRecord, i);
						iCounter++;
					}
				}
				in.close();
			} catch (IOException e) {
				System.err.println("Error: " + e);
			}
		} catch (FileNotFoundException e) {
			System.err.println("���� �� ����� ���� ������: " + e);
		}
	}

	/**
	 * �������������� �������� � ������� ��� ������������� ������.
	 * 
	 * @param record
	 *            - ������ �������
	 * @param counter
	 *            - �������
	 * @return
	 */
	private int returnCharValue(String record, int counter) {
		if (record.charAt(counter) == 49) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * �������������� ������� � ������ ��� �������� ������.
	 * 
	 * @return - ������� �����������.
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < picturePixels.length; i++) {
			for (int j = 0; j < picturePixels.length; j++) {
				if (picturePixels[i][j] == 1)
					result += picturePixels[i][j];
				else
					result += " ";
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * ������� ����������� ������� � ����������
	 * 
	 * @return ���������� ������
	 */
	public int[] makeOneDimensional() {
		int[] result = new int[size * size];
		int counter = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				result[counter] = this.picturePixels[i][j];
				counter++;
			}
		}
		return result;
	}

	public void show() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (picturePixels[i][j] == -1)
					System.out.print(" ");
				else
					System.out.print(picturePixels[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
