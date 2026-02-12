package com.code.challenges.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {

	public  static String simplifyPath(String path) {
		path = removeDuplicateSlashes(path);
		String [] paths = path.split("/");
		Deque<String> queue = new LinkedList<String>();
		StringBuilder sb = new StringBuilder("/");
		for (int i = 0; i < paths.length; i++) {
			String temp = paths[i];
			if (temp.equals(".") || temp.isEmpty()) {
				continue;
			} else if (temp.equals("..") && !queue.isEmpty()){
				queue.pollLast();
				
			} else if (!temp.equals("..")){
				queue.add(temp);
			}  
		}
		while (!queue.isEmpty()) {
			
			sb.append(queue.pollFirst());
			if (!queue.isEmpty()) {
				sb.append("/");
			}
			
		}
        return sb.toString();
    }
	
	private static String removeDuplicateSlashes(String arg) {
		while (arg.contains("//")) {
			arg = arg.replace("//", "/");
		}
		return arg;
	}
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("/home///////////foo/"));
		System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
		System.out.println(simplifyPath("/home/"));
	}
}
