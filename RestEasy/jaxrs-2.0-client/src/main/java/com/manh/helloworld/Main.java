package com.manh.helloworld;

import java.io.File;

public class Main
{
	public static void main(String[] args) 
	{
		File f=new File("A.txt");
		System.out.println(f.getAbsolutePath());
		String ss[]=f.getAbsolutePath().split("\\\\");
		for(int i=0;i<ss.length;i++)
		{
			System.out.println(ss[i]);
		}
		
		
	}
}
