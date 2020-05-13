import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProcessing {

	public ImageProcessing() {

	}

	public Matrix getArrayFromBinaryImage(String fileName) {
		BufferedImage source;
		Matrix resultImage = null;
		try {
			source = ImageIO.read(new File(fileName));
			int rowCount = source.getHeight();
			int colCount = source.getWidth();
			resultImage = new Matrix(rowCount, colCount);
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					Color pixelColor = new Color(source.getRGB(j, i));
					int red = (int) (pixelColor.getRed());
					int green = (int) (pixelColor.getGreen());
					int blue = (int) (pixelColor.getBlue());
					if (red > 240 && green > 240 && blue > 240)
						resultImage.setValue(i, j, 255);
					else
						resultImage.setValue(i, j, 0);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultImage;
	}
	
	public Matrix getArrayFromGrayScaleImage(String filename){
		BufferedImage source;
		Matrix resultImage = null;
		try {
			source = ImageIO.read(new File(filename));
			int rowCount = source.getHeight();
			int colCount = source.getWidth();
			resultImage = new Matrix(rowCount, colCount);
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					Color pixelColor = new Color(source.getRGB(j, i));
					int red = pixelColor.getRed();
					int green = pixelColor.getGreen();
					int blue = pixelColor.getBlue();
					int avg = (red + green + blue) / 3;
					resultImage.setValue(i, j, avg);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultImage;
	}

	public Matrix getNeighborhood(Matrix matrix, int x, int y, int n) {
		Matrix neighborhood = new Matrix(n, n);
		int rowCount = matrix.getRowCount();
		int colCount = matrix.getColumnCount();
		int k = n % 2 != 0 ? n / 2 : -1;
		int nRow = 0, nCol = 0;
		for (int i = x - k; i <= x + k; i++) {
			for (int j = y - k; j <= y + k; j++) {
				if (i >= 0 && i < colCount && j >= 0 && j < rowCount) {
					neighborhood.setValue(nRow, nCol, matrix.getValue(j, i));
				} else {
					neighborhood.setValue(nRow, nCol, 0);
				}
				nRow++;
			}
			nRow = 0;
			nCol++;
		}
		return neighborhood;
	}

	public boolean isBlack(byte color, byte threshold) {
		return color < threshold;
	}

	public void writeMonoChromeImage(Matrix source, String filename, String extension) {
		int width = source.getColumnCount();
		int height = source.getRowCount();
		BufferedImage tmp = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 0; i < source.getRowCount(); i++) {
			for (int j = 0; j < source.getColumnCount(); j++) {
				int value = source.getValue(i, j) == 1 ? 255 : 0;
				tmp.setRGB(j, i, new Color(value, value, value).getRGB());
			}
		}
		try {
			ImageIO.write(tmp, extension, new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeGrayScaleImage(Matrix source, String filename, String extension){
		int width = source.getColumnCount();
		int height = source.getRowCount();
		BufferedImage tmp = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		for (int i = 0; i < source.getRowCount(); i++) {
			for (int j = 0; j < source.getColumnCount(); j++) {
				int value = source.getValue(i, j);
				tmp.setRGB(j, i, new Color(value, value, value).getRGB());
			}
		}
		try {
			ImageIO.write(tmp, extension, new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Array getHistogram(Array source){
		Array histogram = new Array(256);
		
		return histogram;
	}
}
