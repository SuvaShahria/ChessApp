/**
 * This class contains unit tests for the MatchServiceImpl class
 * 
 * NOTE: MatchServiceImpl is not yet fully implemented
 * 
 * @author Andrew Curry
 */
package com.revature.service;

import static org.mockito.Mockito.mock;

import com.revature.repository.interfaces.MatchRepository;
import com.revature.service.impl.MatchServiceImpl;
import com.revature.service.interfaces.MatchService;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TestMatchServiceImpl {
    
    // ---------------------
    // SETUP / SUPPORT
    // ---------------------

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private MatchService mService; // will actually be impl
    private MatchRepository mRepo; // will be mocked

    @Before
    @SuppressWarnings(value="all") // what could go wrong?
    public void setup(){
        mRepo = mock(MatchRepository.class);
        mService = new MatchServiceImpl();
        mService.useOutsideRepository(mRepo);
    }

    // ---------------------
    // TESTS
    // ---------------------

    // ---------------------
    // save() TESTS
    // ---------------------

    // currently not testing this because it just calls the repo

    // ---------------------
    // find-by-mr/id/code TESTS
    // ---------------------

    // currently not testing these because it just calls the repo
}
