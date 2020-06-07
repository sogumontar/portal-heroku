package com.example.PortalDesa.serviceImpl;

import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.repository.UsersRepo;
import com.example.PortalDesa.service.implement.UsersServiceImpl;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/05/2020.
 */
public class UsersServiceImplTests {

    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    public Users users;
    @Mock
    public UsersRepo usersRepo;
    @InjectMocks
    public UsersServiceImpl  usersService;

    @Test
    public void findByUsername() {
        Users list=new Users();
        Mockito.when(usersRepo.findByUsername("hendra")).thenReturn(list);
        assertEquals(list,usersService.findByUsername("hendra"));
        Mockito.verify(usersRepo).findByUsername("hendra");
    }

    @Test
    public void findAllAccountCustomer() {
        List list = new ArrayList();
        Mockito.when(usersRepo.findAllByRoles(1)).thenReturn(list);
        assertEquals(list,usersService.findAllAccountCustomer());
        Mockito.verify(usersRepo).findAllByRoles(1);
    }
    @Test
    public void findAllAccountMerchant() {
        List list = new ArrayList();
        Mockito.when(usersRepo.findAllByRoles(3)).thenReturn(list);
        assertEquals(list,usersService.findAllAccountMerchant());
        Mockito.verify(usersRepo).findAllByRoles(3);
    }
    @Test
    public void findAllAccountAdmin(){
        List list = new ArrayList();
        Mockito.when(usersRepo.findAllByRoles(2)).thenReturn(list);
        assertEquals(list,usersService.findAllAccountAdmin());
        Mockito.verify(usersRepo).findAllByRoles(2);
    }

}
