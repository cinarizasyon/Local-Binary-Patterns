
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ImageProcessing ip = new ImageProcessing();
		Matrix sourceImage = ip.getArrayFromGrayScaleImage("satranc.png");
		//System.out.println(sourceImage.toString());
		LocalBinaryPattern lbp = new LocalBinaryPattern(sourceImage);
		Matrix result = lbp.LBP();
		//System.out.println(result.toString());
		ip.writeGrayScaleImage(result, "result.jpg", "jpg");
		System.out.println("Sonuç proje dizininde result.jpg adlý dosyaya çýkartýldý.");
	}
}
