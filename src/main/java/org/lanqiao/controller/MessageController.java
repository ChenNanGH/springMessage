package org.lanqiao.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.lanqiao.entity.Message;
import org.lanqiao.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {
	@Autowired
	MessageServiceImpl messageServiceImpl;

	@RequestMapping("show")
	public String show(Model model, String p) {
		String pageNum = p;
		int pageSize = 2;
		if (pageNum == null) {
			pageNum = "1";
		}
		List<Message> list = messageServiceImpl.showMessage(Integer.parseInt(pageNum), pageSize);
		int maxPage = messageServiceImpl.getmaxpage(pageSize);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("mesList", list);
		model.addAttribute("p", Integer.parseInt(pageNum));

		return "forward:Message";

	}

	@RequestMapping("SearchServlet")
	public String SearchServlet(Model model, @RequestParam Map<String, Object> map) {
		String title=(String) map.get("title");
		title="%"+title+"%";
		String beginTime=(String) map.get("beginTime");
		String endTime=(String) map.get("endTime");
		if(beginTime.equals("")){
			map.put("beginTime", null);
		}
		if(endTime.equals("")){
			map.put("endTime", null);
		}
		int pageSize = 2;
		int pageNum = 1;
		map.put("title", title);
		map.put("pageSize", pageSize);
		map.put("beginNum", pageSize * (pageNum - 1));
		List<Message> list = messageServiceImpl.searchMes(map);
		model.addAttribute("mesList", list);
		model.addAttribute("p", pageNum);
		model.addAttribute("maxPage", messageServiceImpl.getmaxpage(pageSize));

		return "forward:Message";

	}

	@RequestMapping("InsertServlet")
	public String InsertServlet(@RequestParam Map<String, Object> map) {

		String name = (String) map.get("author");
		String id = (String) map.get("id");
		String content = (String) map.get("message");
		Date date = new Date();
		int idd = ("id" != null && !id.equals("")) ? Integer.parseInt(id) : 0;
		Message message = new Message(idd, name, content, date);
		int ret = messageServiceImpl.insert(message);
		return "forward:show";

	}

	@RequestMapping("Message")
	public String Message() {
		return "Message";

	}
}
