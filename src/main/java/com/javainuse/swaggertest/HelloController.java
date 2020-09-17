package com.javainuse.swaggertest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;

@RestController
public class HelloController {
	
	public static final RethinkDB r = RethinkDB.r;
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
	public String sayHello() {
		return "Swagger Hello World";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/vimal")
	public String sayVimal() {
		return "Swagger Hello vimal";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/name/{id}")
	public Object get_data(@PathVariable("id") String id) {
		Connection conn = r.connection().hostname("ec2-13-233-208-178.ap-south-1.compute.amazonaws.com").port(28015).connect();
		Object res = null;
		Cursor cursor = r.table("authors").filter(row -> row.g("name").eq(id)).run(conn);
		for (Object doc : cursor) {
		    res = doc;
		}
		conn.close();
		return res;
	}
}
