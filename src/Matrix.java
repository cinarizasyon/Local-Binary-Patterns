
public class Matrix {

	private int[][] matrix;

	public Matrix() {
		matrix = new int[0][0];
	}

	public Matrix(int rowCount, int columnCount) {
		matrix = new int[rowCount][columnCount];
	}

	public int getValue(int row, int column) {
		return matrix[row][column];
	}

	public void setValue(int row, int column, int value) {
		matrix[row][column] = value;
	}

	public int getRowCount() {
		return matrix.length;
	}

	public int getRowCount(int[][] matrix) {
		return matrix.length;
	}

	public int getColumnCount() {
		return matrix[0].length;
	}

	public int getColumnCount(int[][] matrix) {
		return matrix[0].length;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < getRowCount(matrix); i++) {
			for (int j = 0; j < getColumnCount(matrix); j++) {
				result += getValue(i, j) + " ";
			}
			result += "\n";
		}
		return result;
	}

	public int getDeterminant2x2() {
		if (getRowCount() == 2 && getColumnCount() == 2)
			return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
		else
			return -1;
	}

	public boolean isSquareMatrix() {
		return getRowCount() == getColumnCount();
	}

	public int getTrace() {
		int result = 0;
		if (isSquareMatrix()) {
			for (int i = 0; i < getRowCount(matrix); i++) {
				for (int j = 0; j < getColumnCount(matrix); j++) {
					if (i == j)
						result += matrix[i][j];
				}
			}
		} else
			result = -1;
		return result;
	}

	public Array getMatrixAxis(boolean axisType, int axisNumber) {
		Array result;
		if (axisType) {
			result = new Array(getRowCount(matrix));
			for (int i = 0; i < getColumnCount(matrix); i++) {
				result.setValue(i, matrix[axisNumber][i]);
			}
		} else {
			result = new Array(getColumnCount(matrix));
			for (int i = 0; i < getRowCount(matrix); i++) {
				result.setValue(i, matrix[i][axisNumber]);
			}
		}
		return result;
	}
}
