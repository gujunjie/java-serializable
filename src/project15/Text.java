package project15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Text {

	public static void main(String[] args) {
		
		//对象序列化过程,把对象序列化成二进制流,通过对象输出流输出为文件存入硬盘
		
		File file=new File("d:\\abc\\person.txt");
		
		Person p1=new Person("华为", 25);
		Person p2=new Person("小米", 515);
		
		FileOutputStream fos =null;
		
		ObjectOutputStream oos=null;
		
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			
			oos.writeObject(p1);
			oos.flush();
			oos.writeObject(p2);
			oos.flush();
			
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(oos!=null)
			{
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		//反序列化，把对象从文件中读取出来
		
		FileInputStream fis =null;
		ObjectInputStream ois =null;
		
		try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			
			Person p3=(Person)ois.readObject();
			Person p4=(Person)ois.readObject();
			
			System.out.println(p3.toString());
			System.out.println(p4.toString());
			
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		

	}

}
