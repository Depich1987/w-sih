// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSJob;
import com.depich1987.wsih.domain.WSUser;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect WSUser_Roo_Finder {
    
    public static TypedQuery<WSUser> WSUser.findWSUsersByJob(WSJob job) {
        if (job == null) throw new IllegalArgumentException("The job argument is required");
        EntityManager em = WSUser.entityManager();
        TypedQuery<WSUser> q = em.createQuery("SELECT o FROM WSUser AS o WHERE o.job = :job", WSUser.class);
        q.setParameter("job", job);
        return q;
    }
    
    public static TypedQuery<WSUser> WSUser.findWSUsersByUserNameEquals(String userName) {
        if (userName == null || userName.length() == 0) throw new IllegalArgumentException("The userName argument is required");
        EntityManager em = WSUser.entityManager();
        TypedQuery<WSUser> q = em.createQuery("SELECT o FROM WSUser AS o WHERE o.userName = :userName", WSUser.class);
        q.setParameter("userName", userName);
        return q;
    }
    
}
