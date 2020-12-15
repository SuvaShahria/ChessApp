/**
 * This class implements the methods needed to access data related to Matches in the db.
 * 
 * NOTE: the implementation is not yet complete.
 * 
 * @author Andrew Curry
 */
package com.revature.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.revature.model.MatchRecord;
import com.revature.model.User;
import com.revature.repository.RepositoryException;
import com.revature.repository.interfaces.MatchRepository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("matchRepository")
@Transactional
public class MatchRepositoryImpl implements MatchRepository{

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Autowired
    private SessionFactory sessionFactory;

    // ---------------------
    // HELPER/TEST METHODS
    // ---------------------

    /**
     * Used for testing, injects a new sessionFactory.
     * 
     * @param sessionFactory
     */
    @Override
    public void useOutsideSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ---------------------
    // DATA ACCESS METHODS
    // ---------------------

    /**
     * Persists the given match record to the database.
     * Works with new AND already-existing entries.
     * 
     * Assumes the fields of the matchRecord are valid.
     * 
     * Throws RepositoryException if there are problems communicating with the database.
     * 
     * @param mr
     * @throws RepositoryException
     */
	@Override
	public void save(MatchRecord mr) throws RepositoryException {
		try{
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(mr);
        } catch(HibernateException e){
            throw new RepositoryException("HibernateException: " + e.getMessage());
        }
	}

	@Override
	public MatchRecord findMatchRecordById(int id) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchRecord findMatchRecordByCode(int code) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatchRecord> findMatchRecordsBy(User user) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatchRecord> findMatchRecordsBy(MatchStatusFilter filter) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatchRecord> findMatchRecordsBy(User user, MatchStatusFilter filter) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}
    
}
