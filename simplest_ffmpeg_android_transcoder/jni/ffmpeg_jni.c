/**
 * ��򵥵Ļ���FFmpeg��ת����-��׿
 * Simplest FFmpeg Android Transcoder
 *
 * ������ Lei Xiaohua
 * leixiaohua1020@126.com
 * �й���ý��ѧ/���ֵ��Ӽ���
 * Communication University of China / Digital TV Technology
 * http://blog.csdn.net/leixiaohua1020
 *
 * �������ǰ�׿ƽ̨�µ�ת����������ֲ��ffmpeg.c�����й��ߡ�
 *
 * This software is a Transcoder in Android. It is transplanted from ffmpeg.c
 * command line tools.
 */
#include <string.h>
#include <jni.h>
#include <ffmpeg.h>



jint
Java_com_leixiaohua1020_sffmpegandroidhelloworld_MainActivity_ffmpegcore( JNIEnv * env, jobject thiz, jint cmdnum, jobjectArray cmdline)
{
  int argc=cmdnum;
  char** argv=(char**)malloc(sizeof(char*)*argc);
  
  int i=0;
  for(i=0;i<argc;i++)
  {
    jstring string=(*env)->GetObjectArrayElement(env,cmdline,i);
    char* tmp=(*env)->GetStringUTFChars(env,string,0);
    argv[i]=(char*)malloc(sizeof(char)*1024);
    strcpy(argv[i],tmp);
  }
  //char* str=(*env)->GetStringUTFChars(env, cmdline,0);
  ffmpegmain(argc,argv);

  for(i=0;i<argc;i++)
  {
    free(argv[i]);
  }
  free(argv);
  return 0;

}
