package org.lanqiao.service;

import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Message;

public interface MessageService {
   public List<Message> showMessage(int pageNum,int pageSize);
   public int getmaxpage(int pageSize);
   public int insert(Message message);
   public List<Message> searchMes(Map map);
}
