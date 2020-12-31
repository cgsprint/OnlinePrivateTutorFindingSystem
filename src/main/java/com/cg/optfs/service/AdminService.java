package com.cg.optfs.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.optfs.entity.Admin;
import com.cg.optfs.entity.Ebook;
import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Tutor;


public interface AdminService {
	
	/**
	 * This method is used to validate the Admin using their credentials
	 * @param username
	 * @param password
	 * @return Admin
	 * @author TEJAS HATLE
	 */
	public Admin loginAdmin(String username, String password);
	
	
	/**
	 * This method is used to add the tutor details in the database.
	 * @param tutor1
	 * @return tutor
	 * @author TEJAS HATLE
	 */

	public Tutor addTutor(Tutor tutor1);
	
	/**
	 * This method is used to get the Tutor object by tutor id
	 * @param id
	 * @return tutor
	 * @author TEJAS HATLE
	 */

	public Optional<Tutor> getTutorById(Long id);

	/**
	 * This method is used to update the tutor
	 * @param tu1
	 * @return Tutor
	 * @author TEJAS HATLE
	 */
	public Tutor updateTutor(Tutor tu1);
	
	/**
	 * This method is used to delete the Tutor
	 * @param tu
	 * @author TEJAS HATLE
	 */

	public void deleteTutor(Tutor tu);
	
	
	/**
	 * This method is used to add the ebook in the database
	 * @param ebook
	 * @return ebook
	 * @author TEJAS HATLE
	 */

	public Ebook addEbook(Ebook ebook);
	
	
	/**
	 * This method is uesd to get ebook by its id
	 * @param id
	 * @return ebook
	 * @author TEJAS HATLE
	 */

	public Optional<Ebook> getEbookById(int id);
	
	/**
	 * This method is used to update the ebook records from database
	 * @param eb
	 * @return ebook
	 * @author TEJAS HATLE
	 */

	public Ebook updateEbook(Ebook eb);
	
	/**
	 * This method is used to delete the ebook record from database
	 * @param eb
	 * @author TEJAS HATLE
	 */

	public void deleteEbook(Ebook eb);
	
	
	/**
	 * This method is used to return the list of registered parents
	 * @return List<Parents>
	 * @author TEJAS HATLE
	 */

	public List<Parent> viewParents();

	
	
}
