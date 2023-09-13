import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.IOException;
import java.nio.file.path;
import java.nio.file.paths;
import java.util.List;
import java.util.stream.Stream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class MarvellousPacker
{
    FileOutputStream outtstrem=null;

    String ValiExt[]={".txt",".c",".java",".cpp"};

    public MarvellousPacker (String src,String Dest)throws Exception
    {
        String Magic ="Marvellous11";
        byte arr[]=Magic.getBytes();
        File outfile= new File(Dest);

        File infile=null;
        outtstrem=new FileOutputStream(Dest);
        outtstrem.write(arr,0,arr.length);

        File foder = new File(src);

        System.setProperty("use.dir",src);

        listAllFiles(src);
    }

    public void listAllFiles(String path)
    {
        try
        (Stream<path>= File.walk(paths.get(path)))
        {
            paths.forEach(filePath ->
            {
                if(Files.isRegualrFile(filePath))
                {
                    try
                    {
                        string name=filePath.getFilename().toString();
                        string ext= name.substring(name.lastIndexOf("."));

                        List<String> list= Arrays.asList(ValiExt);

                        if(list.contains(ext))
                        {
                            file file=new file(filePath.getFilename().toString());

                            pack(file.getAbsolutePath());
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.pritln(e);
                    }
                }
            })

        }
        catch(IOException e)
        {
            System.out.pritln(e);
        }
    }
    public void Pack (String filePath)
    {
        FileInputStream instream=null;

        try
        {
            byte [] buffer = new byte [1024];

            int length;

            byte temp []= new byte[100];

            File fobj= new File(filePath);

            String Header= filePath +" "+fobj.length();

            for(int i= Header.length();i<100;i++)
            Header +=" ";

            temp=Header.getBytes();
            instream=new FileInputStream(filePath);
            outtstrem.write(temp,0,temp.length);
            while((length=instream.read(buffer))>0)
            {
                outtstrem.write(buffer,o,length);
            }
            instream.close();
        }
        catch (Exception e)
        {
            System.out.pritln(e);
        }
    }
}


