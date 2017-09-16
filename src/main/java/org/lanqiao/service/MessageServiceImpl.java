package org.lanqiao.service;

import java.util.List;
import java.util.Map;

import org.lanqiao.dao.MessageDao;
import org.lanqiao.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;

	@Override
	public List<Message> showMessage(int pageNum,int pageSize) {
		
		
		return messageDao.showMessage(pageSize*(pageNum-1),pageSize);
	}

	@Override
	public int getmaxpage(int pageSize) {
        int count=messageDao.getmaxpage();
		return count%pageSize==0 ? count/pageSize : count/pageSize+1;
	}

	@Override
	public int insert(Message message) {
		int ret=messageDao.insert(message);
		return ret;
	}

	@Override
	public List<Message> searchMes(Map map) {
		return messageDao.searchMes(map);
	}

}
