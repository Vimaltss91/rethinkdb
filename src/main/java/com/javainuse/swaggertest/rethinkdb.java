package com.javainuse.swaggertest;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.exc.ReqlError;
import com.rethinkdb.gen.exc.ReqlQueryLogicError;
import com.rethinkdb.model.MapObject;
import com.rethinkdb.net.Connection;


public class rethinkdb {
	
	public static final RethinkDB r = RethinkDB.r;
	
	public static void main(String[] args) {
		Connection conn = r.connection().hostname("ec2-13-233-208-178.ap-south-1.compute.amazonaws.com").port(28015).connect();
		//r.db("test").tableCreate("movie").run(conn);
		r.table("authors").insert(r.array(
			    r.hashMap("name", "William Adama")
			     .with("tv_show", "Battlestar Galactica")
			     .with("posts", r.array(
			        r.hashMap("title", "Decommissioning speech")
			         .with("content", "The Cylon War is long over..."),
			        r.hashMap("title", "We are at war")
			         .with("content", "Moments ago, this ship received..."),
			        r.hashMap("title", "The new Earth")
			         .with("content", "The discoveries of the past few days...")
			        )
			    ),
			    r.hashMap("name", "Laura Roslin")
			     .with("tv_show", "Battlestar Galactica")
			     .with("posts", r.array(
			        r.hashMap("title", "The oath of office")
			         .with("content", "I, Laura Roslin, ..."),
			        r.hashMap("title", "They look like us")
			         .with("content", "The Cylons have the ability...")
			        )
			    ),
			    r.hashMap("name", "Jean-Luc Picard")
			     .with("tv_show", "Star Trek TNG")
			     .with("posts", r.array(
			        r.hashMap("title", "Civil rights")
			         .with("content", "There are some words I've known since...")
			        )
			    )
			)).run(conn);
	}
	

}
