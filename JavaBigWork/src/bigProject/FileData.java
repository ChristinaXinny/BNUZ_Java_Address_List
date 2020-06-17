package bigProject;

/**
 * 
 */
//package bigBigWork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * @author ChristinaXinny
 * @Date: 2020年6月8日 下午5:04:09
 */



public class FileData {

	private ArrayList<Person> alp = new ArrayList<Person>();

	public FileData() {
		super();
//		readFile();
		
	}
	
	
	
	
	
	
//	把文件每行string读到al中
	public void readFile() {
		try {
			alp.clear();
			BufferedReader in = new BufferedReader(new FileReader("Person.txt"));
			String line = null;
			while ((line = in.readLine()) != null) {
				String[] b = line.split(" ");
				String id = b[0].substring(b[0].indexOf("=")+1);
				String name = b[1].substring(b[1].indexOf("=")+1);
				String age = b[2].substring(b[2].indexOf("=")+1);
				String phone = b[3].substring(b[3].indexOf("=")+1);
				Person p = new Person(id, name, age, phone);	
				alp.add(p);
			}
			in.close();
			System.out.println("the file have:");
			System.out.println("******start******");
			for(Person s : alp) {
				System.out.println(s.toString());
			}
			System.out.println("------end------");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile() {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Person.txt")));
			for (Person s : alp) {
				out.write(s.toStrWithReFile());
				out.write("\n");
			}
			out.close();
			System.out.println("we will close the procedure now we have:");
			System.out.println("******start******");
			for(Person s : alp) {
				System.out.println(s.toString());
			}
			System.out.println("------end------");
			alp.clear();// 清空
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 清空已有的文件内容，以便下次重新写入新的内容
    public String clearFile() {
        try {
        	BufferedWriter bw = new BufferedWriter(new FileWriter("Person.txt", false));
			bw.write("");// toString自带\n
			bw.close();
			alp.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "清除成功";
    }

	/*
	 * 0123456789. id=Q name=QQ phone=QQQ 格式 可以用subString截取出string的一部分 String sb =
	 * "bbbdsajjds"; sb.substring(2,
	 * 4);--》从索引号2开始到索引好4结束（并且不包含索引4截取在内，也就是说实际截取的是2和3号字符）bd 根据id 返回行号 没有返回-1
	 */
	public int readFileByID(String key) {
		String str = null;
		int index = -1;
		int i = 0;
		for (Person p : alp) {
			String s = p.toString();
			str = s.substring(3, s.indexOf(' '));
			System.out.println("id:"+str);
			if (str.equals(key)) {// 找到匹配id   str.equals(key)不可以用== 这个==是用来比较地址
				index = i;
				System.out.printf("key:%s By id index:%d\n", key, index);
				break;
			}
			i++;
		}
		return index;

	}
	public int readFileByName(String key) {
		String str = "";
		int index = -1;
		int i = 0;
//		String[] b = new String[3];
		for (Person p : alp) {
			String s = p.toString();
			String[] b = s.split(" ");
			str = b[1].substring(b[1].indexOf("=")+1);
			System.out.println("name:"+str);
			if (str.equals(key)) {// 找到匹配name   str.equals(key)不可以用== 这个==是用来比较地址
				index = i;
				System.out.printf("key:%s By id index:%d\n", key, index);
				break;
			}
			i++;
		}
		return index;
		
	}
	public int readFileByPhone(String key) {
		String str = "";
		int index = -1;
		int i = 0;
//		String[] b = new String[3];
		for (Person p : alp) {
			String s = p.toString();
			String[] b = s.split(" ");
			str = b[3].substring(b[3].indexOf("=")+1);
			System.out.println("phone:"+str);
			if (str.equals(key)) {// 找到匹配name   str.equals(key)不可以用== 这个==是用来比较地址
				index = i;
				System.out.printf("key:%s By id index:%d\n", key, index);
				break;
			}
			i++;
		}
		return index;
		
	}
	public int readFileByAge(String key) {
		String str = "";
		int index = -1;
		int i = 0;
		for (Person p : alp) {
			String s = p.toString();
			String[] b = s.split(" ");
			str = b[2].substring(b[2].indexOf("=")+1);
			System.out.println("age:"+str);
			if (str.equals(key)) {// 找到匹配name   str.equals(key)不可以用== 这个==是用来比较地址
				index = i;
				System.out.printf("key:%s By id index:%d\n", key, index);
				break;
			}
			i++;
		}
		return index;
		
	}
	
	public int findFileBySomething(String key, int cmd) {
		String str = "";
		int index = -1;
		int i = 0;
		for (Person p : alp) {
			String s = p.toString();
			String[] b = s.split(" ");
			str = b[cmd].substring(b[cmd].indexOf("=")+1);
			System.out.printf("**%d**: %s\n", cmd, str);
			if (str.equals(key)) {// 找到匹配name   str.equals(key)不可以用== 这个==是用来比较地址
				index = i;
				System.out.printf("key by **%d** index: %d\n", cmd, index);
				break;
			}
			i++;
		}
		return index;
		
	}
	
	public void crFile(Person p) {
		System.out.println("************* Create ************");
			alp.add(p);
			System.out.println(p);
			
	}
	

	/*
	 * 删除 查找到id所在的下标
	 */
	public String deById(String key) {
		System.out.println("*********** Delete by id *************");
		int index = readFileByID(key);
		if (index != -1) {
			System.out.println(alp.get(index));
			alp.remove(index);
			return "删除成功\n";
		} else {// 没有找到对应的id
			return "删除失败\n没有找到对应id";
		}
	}
	
	public String deByName(String key) {
		System.out.println("************ Delete by name ***********");
		int index = findFileBySomething(key, 1);
		if (index != -1) {
			System.out.println(alp.get(index));
			alp.remove(readFileByName(key));
			return "删除成功辣";
		} else {// 没有找到对应的id
			return "删除失败嗷\n没有找到对应name";
		}
	}

	
	/*
	 * Revise修改 先把文件东西读入程序中的al 
	 * 操作： 
	 * 找到下标 置换 在把al中的东西 存到文件中 刷新文件内容 
	 * 找到id 返回true
	 */
	public String reFile(Person p, String key) {
		System.out.println("************** Revise ****************");
		int index = readFileByID(key);
		if (index != -1) {
			System.out.println(alp.get(index));
			alp.set(index, p);
			return "修改成功";
		} else {// 没有找到对应的id
			return "修改失败\n没有找到对应id";
		}
	}

	public String quFile(String key, int cmd) {
		System.out.println("***************** Query ******************");
			int index = findFileBySomething(key, cmd);
			if(index!=-1) {
				System.out.println(alp.get(index));
				return alp.get(index).toString();
			}
			else {
				return "**没有找到**";
			}
	}
	
	public String quAll() {
		System.out.println("***************** Query all *****************");
		String ss = "";
		for(Person p : alp) {
			System.out.println(p);
			ss += p.toString();
			ss += "\n";
		}
		return ss;
	}

	
	public static void main(String[] args) {
		

	}

}
