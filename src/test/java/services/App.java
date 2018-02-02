package services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.MailMail;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
             new ClassPathXmlApplicationContext("PopulateDatabase.xml");
    	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("tazuispp@outlook.com",
    		   "menendezcharlo@gmail.com",
    		   "Testing123", 
    		   "Testing only \n\n Hello Spring Email Sender");
        
    }
}