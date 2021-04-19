package ir.persikala.req;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
		File out1 = new File("C:\\Users\\ali\\Pictures\\semsari-doc" + uuid+ ".txt");
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
			File out3 = new File("C:\\Users\\ali\\Pictures\\semsari-doc" + uuid + ".jpg");
			InputStream in = new ByteArrayInputStream(image1Byte);
			BufferedImage img3 = ImageIO.read(in);
			ImageIO.write(img3, "jpg", out3);
			return uuid.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("error image entering 3");
		}
	}
	
	
	public byte[] findPic(String imgName) {
		try {
			File imageFile1 = new File("C:\\Users\\ali\\Pictures\\semsari-doc" + imgName + ".jpg");
			BufferedImage image1 = ImageIO.read(imageFile1);
			ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
			ImageIO.write(image1, "jpg", baos1);
			return baos1.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String convertBlogHead(String blogName) throws Exception{
        try {
		File file = new File("C:\\Users\\ali\\Pictures\\semsari-doc" + blogName + ".txt");
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray);
		fis.close();
		String string=new String(bytesArray ,StandardCharsets.UTF_8);
		return string;
        }catch (Exception e) {
			throw new Exception("file not find");
		}
}
}
