package com.javainuse.swaggertest;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;

public class getrethinkdb {

	public static final RethinkDB r = RethinkDB.r;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = r.connection().hostname("ec2-13-233-208-178.ap-south-1.compute.amazonaws.com").port(28015).connect();
		System.out.println("After connection");
		@SuppressWarnings("rawtypes")
		Cursor cursor = r.table("authors").filter(row -> row.g("name").eq("Laura Roslin")).run(conn);
		for (Object doc : cursor) {
		    System.out.println(doc);
		}
		conn.close();
	}

}
