package com.hisoft.service;

public interface RedisService {
void setObj(String key,Object obj,long Timeout);
Object getObj(String key);
}
