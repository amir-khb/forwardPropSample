import java.io.*;

public class FileReaderHelper {
	File file;
	BufferedReader br;
	int dataSetNum;
	int attributeNum;

	public FileReaderHelper(String path, int dataSetNum, int attributeNum) throws FileNotFoundException {
		file = new File(path);
		br = new BufferedReader(new FileReader(file));
		this.dataSetNum = dataSetNum;
		this.attributeNum = attributeNum;
	}

	public void addToArrayHelper(double[] d, int counter, int i, String st) {
		if (st.substring(0, i).equals("?")) {
			d[counter] = 0;
		} else {
			d[counter] = Integer.parseInt(st.substring(0, i));
		}
	}

	public double[][] textToArray() throws IOException {
		String st;
		double[][] arr = new double[attributeNum][dataSetNum];

		int counter = 0;
		int inputIf = 0;
		int whileCounter = 0;

		while ((st = br.readLine()) != null) {
			for (int i = 0; i < st.length(); i++) {
				if (st.charAt(i) == ',' && inputIf == 0) {
					addToArrayHelper(arr[0], counter, i, st);
					st = st.substring(i + 1);
					i = 0;
					inputIf++;
				} else if (st.charAt(i) == ',' && inputIf == 1) {
					addToArrayHelper(arr[1], counter, i, st);
					st = st.substring(i + 1);
					i = 0;
					inputIf++;
				} else if (st.charAt(i) == ',' && inputIf == 2) {
					addToArrayHelper(arr[2], counter, i, st);
					st = st.substring(i + 1);
					i = 0;
					inputIf++;
				} else if (st.charAt(i) == ',' && inputIf == 3) {
					addToArrayHelper(arr[3], counter, i, st);
					st = st.substring(i + 1);
					i = 0;
					inputIf++;
				} else if (st.charAt(i) == ',' && inputIf == 4) {
					addToArrayHelper(arr[4], counter, i, st);
					st = st.substring(i + 1);
					i = 0;
					inputIf++;
				} else if (st.charAt(i) == ',' && inputIf == 5) {
					addToArrayHelper(arr[5], counter, i, st);
					st = st.substring(i + 1);
					i = 0;
					inputIf++;
				} else if (st.charAt(i) == ',' && inputIf == 6) {
					addToArrayHelper(arr[6], counter, i, st);
					st = st.substring(i + 1);
					i = 0;
					inputIf++;
				} else if (st.charAt(i) == ',' && inputIf == 7) {
					addToArrayHelper(arr[7], counter, i, st);
					st = st.substring(i + 1);
					i = 0;
					inputIf++;
				} else if (st.charAt(i) == ',' && inputIf == 8) {
					addToArrayHelper(arr[8], counter, i, st);
					st = st.substring(i + 1);
					i = 0;
					inputIf++;
				} else if (st.charAt(i) == ',' && inputIf == 9) {
					addToArrayHelper(arr[9], counter, i, st);
					st = st.substring(i + 1);
					arr[10][counter] = Integer.parseInt(st);
					inputIf = 0;
					counter++;
					break;
				}
			}
			if (whileCounter == dataSetNum - 1) {
				break;
			}
			whileCounter++;
		}
		return arr;
	}
}