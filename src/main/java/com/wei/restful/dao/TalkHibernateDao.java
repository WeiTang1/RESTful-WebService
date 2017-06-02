package com.wei.restful.dao;

import com.wei.restful.model.Talk;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by danieltang on 5/30/17.
 */
public class TalkHibernateDao extends HibernateDaoSupport implements TalkDAO {

    @Transactional
    public void save(Talk talk) {
        System.out.println("create new employee " + talk.getSpeaker());
        getHibernateTemplate().save(talk);
        System.out.println("after HibernateTemplate save()");
    }
    @Transactional
    public void update(Talk talk,int id) {
        System.out.println("I am in update");
        talk.setId(id);
        getHibernateTemplate().update(talk);
    }

    @Transactional
    public void delete(Talk talk) {
        System.out.println("In TalkDao delete");
        getHibernateTemplate().delete(talk);
    }

    @Transactional
    public void delete(int id){
        Talk talk = new Talk();
        talk.setId(id);
        delete(talk);
    }

    @Transactional(readOnly = true)
    public Talk get(int id){
        List list = getHibernateTemplate().find("From Talk where id =?",id);
        System.out.println(((Talk)list.get(0)).getName());
        return (Talk)list.get(0);
    }

    @Transactional
    public List list(){
        List list = getHibernateTemplate().loadAll(Talk.class);
        return list;
    }

}
