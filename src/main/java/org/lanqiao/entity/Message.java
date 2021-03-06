package org.lanqiao.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Message {
    private Integer id;

    private String name;

    private String content;
@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    public Message() {
	super();
}

	public Message(Integer id, String name, String content, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.date = date;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}