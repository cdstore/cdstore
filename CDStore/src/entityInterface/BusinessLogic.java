package entityInterface;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


import entity.*;

public class BusinessLogic {
	Collection<Category> categories;
	Collection<Cds> cds;
	Collection<Address> address;
	Collection<Customer> customer;
	
//	public Collection<Category> getCategories(){
//		return this.categories;
//	}
//	public void setCategories(Collection<Category> categories){
//		this.categories=categories;
//	}
//	public Collection<Cds> getCds(){
//		return this.cds;
//	}
//	public void setCds(Collection<Cds> cds){
//		this.cds=cds;
//	}
//	public Collection<Address> getAddress(){
//		return this.address;
//	}
//	public void setAddress(Collection<Address> address){
//		this.address=address;
//	}
//	public Collection<Customer> getCustomer(){
//		return this.customer;
//	}
//	public void setCustomer(Collection<Customer> customer){
//		this.customer=customer;
//	}
	
	public Collection<Category> getCategories(ArrayList<String[]> ResultSet){
		//Set Result Set into iterator to help with 
		Iterator<String[]> iterator=ResultSet.iterator();
		while(iterator.hasNext()){
			String[] row=(String[])iterator.next();
			Category category=new Category();
			category.setCategoryID(Integer.parseInt(row[0]));
			category.setCategoryName(row[1]);
			categories.add(category);
		}

		return categories;
	}
	
	public Collection<Cds> getCdsPerCategory(ArrayList<String[]> ResultSet){
		Iterator<String[]> iterator=ResultSet.iterator();
		while(iterator.hasNext()){
			String[] row=iterator.next();
			Cds cd=new Cds();
			cd.setid(Integer.parseInt(row[0]));
			cd.setCategoryID(Integer.parseInt(row[1]));
			BigDecimal price=new BigDecimal(row[2]);
			cd.setPrice(price);
			
		}

		return cds;
	}
	
}
