import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SpomspFormatter {



    public static String readMessage(DataInputStream sIn){
        String data=null;
        try {

            int version=(int) sIn.read();
            int code=(int) sIn.read();
            int lenght_1=(int) sIn.read();
            int lenght_2=(int) sIn.read();
            byte[] msg=new byte[lenght_1+lenght_2*256];

            sIn.read(msg,0,lenght_1+lenght_2*256);

            data=new String(msg,"UTF-8");



        }
        catch(IOException ex){
            System.out.println("Message error: " + ex.getMessage());
        }
        finally {
            return data;
        }


    }


    public static byte[] msgFormat(int code,byte[] data){
        int version=1;
        int d_lenght_1=0;
        int d_lenght_2=0;


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int a=data.length+4;
        byte[] msg=new byte[a];
        System.out.println(a);
        int dataLen=a-4;
        if(dataLen<=256){
            d_lenght_2=0;
            d_lenght_1=dataLen;
        }
        else{
            d_lenght_2=dataLen/256;
            d_lenght_1=dataLen-(d_lenght_2*256);

        }


        outputStream.write((byte) version);
        outputStream.write((byte) code);
        outputStream.write((byte) d_lenght_1);
        outputStream.write((byte) d_lenght_2);

        try {
            outputStream.write(data);
        }
        catch (IOException ex){
            System.out.println("Message error: " + ex.getMessage());
        }
        msg=outputStream.toByteArray();


        return msg;
    }
}
