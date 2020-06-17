/**
 * 
 */
package bigProject;

/**
 * @author ChristinaXinny
 * @Date: 2020年5月30日 下午1:04:52 
 */
public class Person {

	public String id;
	public String name;
	public String age;
	public String phone;

	public Person() {

	}

	public Person(String id, String name, String age, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
//		return String.format("	\n	id=%s,\n	name=%s, \n	phone=%s", id, name, phone);
		return String.format("id=%s name=%s age=%s phone=%s \n", id, name, age, phone);
	}
	
	
	public String toStrWithReFile() {
//		return String.format("	\n	id=%s,\n	name=%s, \n	phone=%s", id, name, phone);
		return String.format("id=%s name=%s age=%s phone=%s", id, name, age, phone);
	}
	
	
	public static void main(String[] args) {

	}

}
