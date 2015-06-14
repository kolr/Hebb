package hebb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Letter {
	/**
	 * Переменная хранит в себе значение количества изображений.
	 */
	private static int counter = 0;
	/**
	 * Размер матрицы. Матрица - квадратная, поэтому значение размера задается
	 * одной переменной.
	 */
	static int size;
	/**
	 * Матрица пикселей ихображения.
	 */
	private int[][] picturePixels;

	/**
	 * Конструктор инициализирует значение размера и создает матрицу.
	 * 
	 * @param size
	 *            - размер матрицы
	 */
	public Letter(int size) {
		super();
		this.size = size;
		picturePixels = new int[size][size];
		counter++;
	}

	/**
	 * Метод позволяет передать значение матрицы пикселей изображения текущего
	 * объекта.
	 * 
	 * @return - матрица изображения.
	 */
	public int[][] getPicturePixels() {
		return picturePixels;
	}

	/**
	 * Чтение матрицы из файла.
	 * 
	 * @param aFilePath
	 *            - путь к файлу
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
			System.err.println("Файл не может быть найден: " + e);
		}
	}

	/**
	 * Преобразование пикселей в удобный для использования формат.
	 * 
	 * @param record
	 *            - строка матрицы
	 * @param counter
	 *            - счетчик
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
	 * Преобразование матрицы в строку для удобного вывода.
	 * 
	 * @return - матрица изображений.
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
	 * Перевод двухмерного массива в одномерный
	 * 
	 * @return одномерный массив
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
