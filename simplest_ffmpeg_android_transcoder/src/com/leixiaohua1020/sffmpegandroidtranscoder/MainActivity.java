/**
 * ��򵥵Ļ���FFmpeg��ת����-��׿
 * Simplest FFmpeg Android Transcoder
 * 
 * ������  Lei Xiaohua
 * leixiaohua1020@126.com
 * ��С��  Ma Xiaoyu
 * maxiaoyucuc@163.com
 * �й���ý��ѧ/���ֵ��Ӽ���
 * Communication University of China / Digital TV Technology
 * http://blog.csdn.net/leixiaohua1020
 * 
 * 
 * �������ǰ�׿ƽ̨�µ�ת����������ֲ��ffmpeg.c�����й��ߡ�
 * 
 * This software is a Transcoder in Android.
 * It is transplanted from ffmpeg.c command line tools.
 * 
 */
package com.leixiaohua1020.sffmpegandroidtranscoder;

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
        
        final EditText cmdEdittext= (EditText) this.findViewById(R.id.editText_cmd);
        Button startButton= (Button) this.findViewById(R.id.button_start);
        
        startButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0){
				String cmdline=cmdEdittext.getText().toString();
		        String[] argv=cmdline.split(" ");
		        Integer argc=argv.length;
		        ffmpegcore(argc,argv);
			}
		});
    }

    public native int ffmpegcore(int argc,String[] argv);
    static{
    	System.loadLibrary("avutil-54");
    	System.loadLibrary("swresample-1");
    	System.loadLibrary("avcodec-56");
    	System.loadLibrary("avformat-56");
    	System.loadLibrary("swscale-3");
    	System.loadLibrary("postproc-53");
    	System.loadLibrary("avfilter-5");
    	System.loadLibrary("avdevice-56");
    	System.loadLibrary("sfftranscoder");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
