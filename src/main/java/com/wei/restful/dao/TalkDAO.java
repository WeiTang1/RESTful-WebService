package com.wei.restful.dao;


import com.wei.restful.model.Talk;

import java.util.List;

/**
 * Created by danieltang on 5/30/17.
 */
public interface TalkDAO {
    void save(Talk talk);
    void update(Talk talk, int id);
    void delete(Talk talk);

}
