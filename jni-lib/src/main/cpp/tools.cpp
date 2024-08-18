#include <iostream>
#include "jni_Tools.h"
#include <pthread.h>

JNIEXPORT jstring JNICALL Java_jni_Tools_bar(JNIEnv *env, jobject thisObject)
{
  jlong self = (jlong)pthread_self();
  pthread_set_qos_class_self_np(QOS_CLASS_BACKGROUND, 0);
  // std::string res("bar");
  std::string self_str = std::to_string(self);
  return env->NewStringUTF(self_str.c_str());
}