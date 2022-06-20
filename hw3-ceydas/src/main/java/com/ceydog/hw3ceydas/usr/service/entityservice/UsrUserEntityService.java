package com.ceydog.hw3ceydas.usr.service.entityservice;

import com.ceydog.hw3ceydas.gen.service.BaseEntityService;
import com.ceydog.hw3ceydas.usr.dao.UsrUserDao;
import com.ceydog.hw3ceydas.usr.entity.UsrUser;
import org.springframework.stereotype.Service;

@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDao> {

    public UsrUserEntityService(UsrUserDao dao) {
        super(dao);
    }

    public UsrUser findByUsername(String username){
        return getDao().findByUsername(username);
    }

    public boolean existsByUsername(String username) { return getDao().existsByUsername(username);}
}
