package man;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.security.auth.login.LoginContext;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;

public class PcmToWavUtil extends Thread {
    private int mBufferSize=500;  //缓存的音频大小
    private int mSampleRate = 8000;// 8000|16000
String inFilename,outFilename;
JProgressBar login;
JDialog frame;
JButton oButton;
    /**
     * pcm文件转wav文件
     *
     * @param inFilename  源文件路径
     * @param outFilename 目标文件路径
     */
    public PcmToWavUtil(String inFilename, String outFilename) {

    	oButton=new JButton("已完成");
    	oButton.addActionListener(new ActionListener() {  
            
    	      @Override  
    	      public void actionPerformed(ActionEvent e) {  
    	       frame.setVisible(false);
    	       
    	      }  
    	  });  
    	this.inFilename=inFilename;
    	this.outFilename=outFilename;
    	frame=new JDialog(frame, "login..");
    	 frame.setSize(200, 300);
    	
      JPanel panel=new JPanel();
    panel.setBounds(100, 100, 250, 100);
    frame.setContentPane(panel);
     login=new JProgressBar();
    login.setBackground(Color.yellow);
    login.setStringPainted(true);
    panel.add(login);
  frame.setSize(300, 100);
  frame.setUndecorated(true);
    frame.setVisible(true);
    
 	}
    	
 public void run()
 {FileInputStream in;
 FileOutputStream out;
 long totalAudioLen;
 long totalDataLen;
 long longSampleRate = mSampleRate;
 int channels = 2;
 long byteRate = 16 * mSampleRate * channels / 8;
 byte[] data = new byte[mBufferSize];
 File huoqu=new File(inFilename);
 try {
	 for(int i=0;i<100;i++)
	 {login.setValue(i);
		 Thread.sleep(100);
	 if(huoqu.exists())
		 {in = new FileInputStream(inFilename);
	     out = new FileOutputStream(outFilename);
	     totalAudioLen = in.getChannel().size();
	     totalDataLen = totalAudioLen + 36;

	     writeWaveFileHeader(out, totalAudioLen, totalDataLen,
	             longSampleRate, channels, byteRate);
	     while (in.read(data) != -1) {
	         out.write(data);
	     }
	     in.close();
	     out.close();
	     huoqu.delete();
	     login.setValue(100);
	   frame.add(oButton);
	   frame.setVisible(true);
	     break;}}
	 
 } catch (IOException e) {
     e.printStackTrace();
 } catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
 }
    /**
     * 加入wav文件头
     */
    private void writeWaveFileHeader(FileOutputStream out, long totalAudioLen,
                                     long totalDataLen, long longSampleRate, int channels, long byteRate)
            throws IOException {
        byte[] header = new byte[44];
        header[0] = 'R'; // RIFF/WAVE header
        header[1] = 'I';
        header[2] = 'F';
        header[3] = 'F';
        header[4] = (byte) (totalDataLen & 0xff);
        header[5] = (byte) ((totalDataLen >> 8) & 0xff);
        header[6] = (byte) ((totalDataLen >> 16) & 0xff);
        header[7] = (byte) ((totalDataLen >> 24) & 0xff);
        header[8] = 'W';  //WAVE
        header[9] = 'A';
        header[10] = 'V';
        header[11] = 'E';
        header[12] = 'f'; // 'fmt ' chunk
        header[13] = 'm';
        header[14] = 't';
        header[15] = ' ';
        header[16] = 16;  // 4 bytes: size of 'fmt ' chunk
        header[17] = 0;
        header[18] = 0;
        header[19] = 0;
        header[20] = 1;   // format = 1
        header[21] = 0;
        header[22] = (byte) channels;
        header[23] = 0;
        header[24] = (byte) (longSampleRate & 0xff);
        header[25] = (byte) ((longSampleRate >> 8) & 0xff);
        header[26] = (byte) ((longSampleRate >> 16) & 0xff);
        header[27] = (byte) ((longSampleRate >> 24) & 0xff);
        header[28] = (byte) (byteRate & 0xff);
        header[29] = (byte) ((byteRate >> 8) & 0xff);
        header[30] = (byte) ((byteRate >> 16) & 0xff);
        header[31] = (byte) ((byteRate >> 24) & 0xff);
        header[32] = (byte) (2 * 16 / 8); // block align
        header[33] = 0;
        header[34] = 16;  // bits per sample
        header[35] = 0;
        header[36] = 'd'; //data
        header[37] = 'a';
        header[38] = 't';
        header[39] = 'a';
        header[40] = (byte) (totalAudioLen & 0xff);
        header[41] = (byte) ((totalAudioLen >> 8) & 0xff);
        header[42] = (byte) ((totalAudioLen >> 16) & 0xff);
        header[43] = (byte) ((totalAudioLen >> 24) & 0xff);
        out.write(header, 0, 44);
    }
}