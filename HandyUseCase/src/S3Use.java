import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class S3Use {

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<byte[]> response = null;

		Scanner scanner = new Scanner(System.in);
		List<String> s = new ArrayList();
		for (int i = 0; i < 110; i++) {
			String s3Url = scanner.next();
			// "https://s3-ap-southeast-1.amazonaws.com/cms-file-uploads-cuat/Test/ff4f1a9b-3515-49aa-b463-95e3d76c66b7_file";

			try {
				System.out.println("FileId :" + i + ", Downloading File From S3");
				response = restTemplate.exchange(s3Url, HttpMethod.GET, entity, byte[].class, "1");
			} catch (Exception e) {
				System.out.println("Erro FileId :" + 1 + ", Downloading File From S3" + e.getStackTrace());
			}

			try {
				Files.write(Paths.get("/Users/sudhanshu.singh/Downloads/rest_verify/" + i + ".csv"),
						response.getBody());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(response.toString());
		}
	}
}
