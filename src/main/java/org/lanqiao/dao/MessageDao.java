package org.lanqiao.dao;

import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Message;

public interface MessageDao {
	int deleteByPrimaryKey(Integer id);

	int insert(Message record);

	int insertSelective(Message record);

	Message selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Message record);

	int updateByPrimaryKey(Message record);

	List<Message> showMessage(int starNum, int pageSize);

	int getmaxpage();

	List<Message> searchMes(Map map);
}