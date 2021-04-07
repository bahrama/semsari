package ir.persikala.req;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.file.UploadedFile;
public class FileConvert {

	public String convertString(String inputString){
		try {
		UUID uuid=UUID.randomUUID();
		byte[] blog = inputString.getBytes(StandardCharsets.UTF_8);
		File out1 = new File("C:\\Users\\Administrator.DESKTOP-KKSACKO\\Pictures\\shahrdari\\" + uuid+ ".txt");
		InputStream in1 = new ByteArrayInputStream(blog);
		OutputStream outputStream = new FileOutputStream(out1);
		outputStream.write(blog);
		outputStream.flush();
		return uuid.toString();
		}catch (IOException e) {
			//e.printStackTrace();
			//throw new Exception("error blog main entering 1");
			return null;
		}
	}
	
	public String convertPicture(UploadedFile pic) throws Exception {
		try {
			UUID uuid=UUID.randomUUID();
			byte[] image1Byte = IOUtils.toByteArray(pic.getInputStream());
			File out3 = new File("C:\\Users\\Administrator.DESKTOP-KKSACKO\\Pictures\\shahrdari\\" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new Exception("error image entering 3");
		}
	}
}
