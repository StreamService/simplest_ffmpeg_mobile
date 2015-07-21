/**
 * ��򵥵Ļ���FFmpeg��������(RTMP)-��׿
 * Simplest FFmpeg Android Streamer (RTMP)
 * 
 * ������ Lei Xiaohua
 * leixiaohua1020@126.com
 * �й���ý��ѧ/���ֵ��Ӽ���
 * Communication University of China / Digital TV Technology
 * http://blog.csdn.net/leixiaohua1020
 * 
 * �������ǰ�׿ƽ̨����򵥵Ļ���FFmpeg����������
 * �����Խ���Ƶ�ļ�����ý�����ʽ���͵���������
 * 
 * This software is the simplest streamer based on FFmpeg in Android.
 * It can stream local media file to streaming media server (in RTMP).
 * 
 */
package com.leixiaohua1020.sffmpegandroidstreamer;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		Button startButton = (Button) this.findViewById(R.id.button_start);
		final EditText urlEdittext_input= (EditText) this.findViewById(R.id.input_url);
		final EditText urlEdittext_output= (EditText) this.findViewById(R.id.output_url);
		
		startButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){

				String folderurl=Environment.getExternalStorageDirectory().getPath();
				
				String urltext_input=urlEdittext_input.getText().toString();
		        String inputurl=folderurl+"/"+urltext_input;
		        
		        String outputurl=urlEdittext_output.getText().toString();
		        
		        Log.e("inputurl",inputurl);
		        Log.e("outputurl",outputurl);
		        String info="";
		    
		        stream(inputurl,outputurl);
		        
		        Log.e("Info",info);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
  //JNI
    public native int stream(String inputurl, String outputurl);
    
    static{
    	System.loadLibrary("avutil-54");
    	System.loadLibrary("swresample-1");
    	System.loadLibrary("avcodec-56");
    	System.loadLibrary("avformat-56");
    	System.loadLibrary("swscale-3");
    	System.loadLibrary("postproc-53");
    	System.loadLibrary("avfilter-5");
    	System.loadLibrary("avdevice-56");
    	System.loadLibrary("sffstreamer");
    }
    
    
}
