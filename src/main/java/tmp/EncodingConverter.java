package tmp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class EncodingConverter {
	
	private String encodingBefore;
	
	private String encodingAfter;
	
	
	
	public EncodingConverter(String encodingBefore, String encodingAfter) {
		super();
		this.encodingBefore = encodingBefore;
		this.encodingAfter = encodingAfter;
	}

	public void convertFiles(String directoryName) throws IOException{
		File directory = new File(directoryName);
		File[] fileArr = directory.listFiles();  
	    for (int i = 0; i < fileArr.length; i++) {  
	        File fileOne = fileArr[i];  
	        if(fileOne.isFile()){
	        	convertFile(fileOne);  
	        }
	       
	    }  

	}
	
	
	
	public void convertFile(File file) throws IOException{
		
		String outDir=file.getParent()+"/out/";
		InputStream is = new FileInputStream(file);
		String outFile=outDir+file.getName();
        OutputStream os = new FileOutputStream(outFile);

        Reader r = new InputStreamReader(is,encodingBefore);
        BufferedReader br = new BufferedReader(r);
        Writer w = new OutputStreamWriter(os,encodingAfter);
        BufferedWriter bw = new BufferedWriter(w);

        String s=null;
        while((s=br.readLine())!=null) {
            bw.write(s);
            bw.write("\n");
        }
        br.close();
        bw.close();
        os.flush();
        System.out.println(outFile+" generated");
	
	}
	public static void main(String[] args) {
		EncodingConverter converter=new EncodingConverter("gb2312","utf-8" );
		try {
			converter.convertFiles("C:/dev/workspace/bbb/src/main/resources/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
