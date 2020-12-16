/**
 * This class implements the methods needed to access data related to Matches in the db.
 * 
 * NOTE: the implementation is not yet complete.
 * 
 * @author Andrew Curry
 */
package com.revature.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.revature.model.MatchRecord;
import com.revature.model.User;
import com.revature.repository.RepositoryException;
import com.revature.repository.interfaces.MatchRepository;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

    /**
     * Returns a mr from the database that matches either the id or code of the given mr.
     * Null if no such mr found.
     * 
     * Throws exception if there is a problem with the db.
     * 
     * @param mr
     * @return
     * @throws RepositoryException
     */
    @Override
    public MatchRecord findMatchRecord(MatchRecord mr) throws RepositoryException{
        MatchRecord result = findMatchRecordById(mr.getId());
        return (result != null) ? result : findMatchRecordByCode(mr.getCode());
    }

    /**
     * Returns the match record corresponding to the given id.
     * If no such match record exists, returns null.
     * 
     * Throws RepositoryException if there is a problem with the database.
     * 
     * @param id
     * @return
     * @throws RepositoryException
     */
	@Override
	public MatchRecord findMatchRecordById(int id) throws RepositoryException {
		try{
            Session session = sessionFactory.getCurrentSession();
            return (MatchRecord)session.get(MatchRecord.class, id);
        } catch(HibernateException e){
            throw new RepositoryException("HibernateException: " + e.getMessage());
        }
	}

    /**
     * Returns the match record corresponding to the given code.
     * If no such match record exists, returns null.
     * 
     * Throws RepositoryException if there is a problem with the database.
     * 
     * @param id
     * @return
     * @throws RepositoryException
     */
    @Override
    @SuppressWarnings(value="unchecked")
	public MatchRecord findMatchRecordByCode(int code) throws RepositoryException {
		try{
            Session session = sessionFactory.getCurrentSession();
            Criteria crit = session.createCriteria(MatchRecord.class);
            crit.add(Restrictions.eq("code", code));
            List<MatchRecord> mrList = crit.list(); // haha, mister list
            return (mrList.isEmpty()) ? null : mrList.get(0);
        } catch(HibernateException e){
            throw new RepositoryException("HibernateException: " + e.getMessage());
        }
	}

    /**
     * Returns the match record corresponding to the given code.
     * If no such match record exists, returns null.
     * 
     * Throws RepositoryException if there is a problem with the database.
     * 
     * @param id
     * @return
     * @throws RepositoryException
     */
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
    
    /**
     * Determines if the db has a MatchRecord matching either the id or code of the given
     * mr.
     * 
     * @param mr
     * @return
     * @throws RepositoryException 
     */
    @Override
    public boolean checkExists(MatchRecord mr) throws RepositoryException{
        return findMatchRecord(mr) != null;
    }

    /**
     * Determines if the db has a MatchRecord matching the given id
     * 
     * @param mr
     * @return
     * @throws RepositoryException 
     */
    @Override
    public boolean checkExistsById(int id) throws RepositoryException{
        return findMatchRecordById(id) != null;
    }

    /**
     * Determines if the db has a MatchRecord matching the given code
     * 
     * @param mr
     * @return
     * @throws RepositoryException 
     */
    @Override
    public boolean checkExistsByCode(int code) throws RepositoryException{
        return findMatchRecordByCode(code) != null;
    }
}
