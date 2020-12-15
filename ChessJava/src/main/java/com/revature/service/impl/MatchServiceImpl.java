package com.revature.service.impl;

import java.util.List;

import com.revature.model.MatchRecord;
import com.revature.model.User;
import com.revature.repository.RepositoryException;
import com.revature.repository.interfaces.MatchRepository;
import com.revature.service.ServiceException;
import com.revature.service.interfaces.MatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("matchService")
public class MatchServiceImpl implements MatchService {

    // ---------------------
    // INSTANCE VARIABLES
    // ---------------------

    @Autowired
    private MatchRepository mRepo;

    // ---------------------
    // TESTER/HELPER METHODS
    // ---------------------

    @Override
    public void useOutsideRepository(MatchRepository mRepo) {
        this.mRepo = mRepo;
    }

    // ---------------------
    // SERVICE METHODS
    // ---------------------

    /**
     * Persists the given match record to the database.
     * Works with new AND already-existing entries.
     * 
     * Assumes the fields of the matchRecord are valid.
     * 
     * Throws ServiceException if there are problems communicating with the database.
     * 
     * @param mr
     * @throws ServiceException
     */
    @Override
    public void save(MatchRecord mr) throws ServiceException {
        try{
            mRepo.save(mr);
        } catch(RepositoryException e){
            throw new ServiceException("RepositoryException: " + e.getMessage());
        }
    }

    @Override
    public MatchRecord findMatchRecord(MatchRecord mr) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MatchRecord findMatchRecordById(int id) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MatchRecord findMatchRecordByCode(int code) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchRecord> findAllMatchRecords() throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchRecord> findAllOngoingMatchRecords() throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchRecord> findAllFinishedMatchRecords() throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchRecord> findAllMatchRecordsWithPlayer(User player) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchRecord> findAllOngoingMatchRecordsWithPlayer(User player) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchRecord> findAllFinishedMatchRecordsWithPlayer(User player) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchRecord> findAllMatchRecordsWithWinner(User player) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MatchRecord> findAllMatchRecordsWithLoser(User player) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void acceptCode(User player, int code) throws ServiceException {
        // TODO Auto-generated method stub

    }
    
}
