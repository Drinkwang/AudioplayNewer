package man;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

import javax.swing.*;

import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;
public class Motherfuck {
	
public static void main(String[] args) {
	
	 JFileChooser jfc = new JFileChooser();
	JFrame frame = new JFrame("人工合成");
	  JTextField userText = new JTextField(20);
      userText.setBounds(100,20,165,25);
frame.setLayout(new GridLayout(7,3));
	JPanel j=new JPanel();
	JPanel j2=new JPanel();
	JLabel label=new JLabel("演讲人");
	   JComboBox<String> comboBox=new JComboBox();  
       comboBox.addItem("小燕");  
       comboBox.addItem("小雨");  
       comboBox.addItem("凯瑟琳");  
       comboBox.addItem("亨利");
       comboBox.addItem("玛丽");
       comboBox.addItem("小研");
       comboBox.addItem("小琪");
       comboBox.addItem("小峰");
       comboBox.addItem("小莉");
       comboBox.addItem("小蓉");
       comboBox.addItem("小坤");
       comboBox.addItem("小强");
       comboBox.addItem("小莹");
       comboBox.addItem("小新");
       comboBox.addItem("楠楠");
       comboBox.addItem("老");
                   comboBox.setBounds(50, 50, 50, 50);
	//oBox.add(s);
	//oBox.add(ds);
      
       JLabel label2=new JLabel("你所要讲诉的文字");
       j2.add(label2);
       j2.add(userText);
       j.add(label);
	j.add(comboBox);
	JPanel j0=new JPanel();
	  JLabel label0=new JLabel("appidid");
	  JTextField appid = new JTextField(20);
	  appid.setText("5a28cf54");
	  j0.add(label0);
	  j0.add(appid);
	  JPanel jspeed=new JPanel();
	  JLabel labelspeed=new JLabel("说话速度");
	  JTextField speed = new JTextField(10);
	  jspeed.add(labelspeed);
	  jspeed.add(speed);
	  JButton baocun=new JButton("保存在路径,文件自动在当前目录下生成555.wav");
	  
	  
	  
	  frame.add(j0);
	 frame.add(j);
	 frame.add(j2);
	 frame.add(jspeed);
	  frame.setBounds(500,200,500, 500);
	 frame.add(baocun);

	frame.setVisible(true);
	baocun.addActionListener(new ActionListener() {
		String sl=null;
		@Override
		public void actionPerformed(ActionEvent e) {SpeechUtility.createUtility(SpeechConstant.APPID +"="+appid.getText());
		if (sl==null) {
			sl=new String();
	 
		if(jfc.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION ){
				   System.out.println(jfc.getSelectedFile().getAbsolutePath());
				   sl=jfc.getSelectedFile().getAbsolutePath();
				 SpeechSynthesizer mTTS=SpeechSynthesizer.createSynthesizer();
					switch ((String)comboBox.getSelectedItem()) {
					case "小燕":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
						break;
					case "小雨":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "xiaoyu");
						break;
					case "凯瑟琳":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "Catherine");
						break;
					case "亨利":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "henry");
						break;
					case "玛丽":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vimary");
						break;
					case "小研":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixy");
						break;
					case "小琪":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixq");
						break;
					case "小峰":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixf");
						break;

					case "小莉":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixl");
						break;
					case "小蓉":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixr");
						break;
					case "小坤":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixk");
						break;
					case "小强":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixqa");
						break;
					case "小莹":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixying");
						break;
					case "小新":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixx");
						break;
					case "楠楠":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vinn");
						break;
					 case "老":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vils");
					 break;
					default:
						break;
					}
				
					
					mTTS.setParameter(SpeechConstant.SPEED, "50");
					mTTS.setParameter(SpeechConstant.VOLUME, "80");

					mTTS.setParameter(SpeechConstant.TTS_AUDIO_PATH, sl+".pcm");
					mTTS.startSpeaking(userText.getText()+"", myListener);
					PcmToWavUtil a=new PcmToWavUtil(sl+".pcm", sl+".wav");




				a.start();
			      //解释下这里,弹出个对话框,可以选择要上传的文件,如果选择了,就把选择的文件的绝对路径打印出来,有了绝对路径,通过JTextField的settext就能设置进去了,那个我没写
			   
			     }
			
			   	
			     }else {
			 		
			    	 SpeechSynthesizer mTTS=SpeechSynthesizer.createSynthesizer();
						switch ((String)comboBox.getSelectedItem()) {
						case "小燕":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
							break;
						case "小雨":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "xiaoyu");
							break;
						case "凯瑟琳":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "Catherine");
							break;
						case "亨利":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "henry");
							break;
						case "玛丽":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vimary");
							break;
						case "小研":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixy");
							break;
						case "小琪":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixq");
							break;
						case "小峰":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixf");
							break;

						case "小莉":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixl");
							break;
						case "小蓉":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixr");
							break;
						case "小坤":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixk");
							break;
						case "小强":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixqa");
							break;
						case "小莹":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixying");
							break;
						case "小新":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vixx");
							break;
						case "楠楠":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vinn");
							break;
						 case "老":	mTTS.setParameter(SpeechConstant.VOICE_NAME, "vils");
						 break;
						default:
							break;
						}
					
						
						mTTS.setParameter(SpeechConstant.SPEED, "50");
						mTTS.setParameter(SpeechConstant.VOLUME, "80");

						mTTS.setParameter(SpeechConstant.TTS_AUDIO_PATH, sl+".pcm");
						mTTS.startSpeaking(userText.getText()+"", myListener);
						PcmToWavUtil a=new PcmToWavUtil(sl+".pcm", sl+".wav");




					a.start();
				}
		
		}
		
		
	});
	
	
	
}

private static SynthesizerListener myListener=new SynthesizerListener() {
	
	@Override
	public void onSpeakResumed() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onSpeakProgress(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onSpeakPaused() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onSpeakBegin() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onEvent(int arg0, int arg1, int arg2, int arg3, Object arg4, Object arg5) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onCompleted(SpeechError arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onBufferProgress(int arg0, int arg1, int arg2, String arg3) {
		// TODO Auto-generated method stub
		
	}
};
}
