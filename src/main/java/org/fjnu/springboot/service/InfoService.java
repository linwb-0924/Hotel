package org.fjnu.springboot.service;

import org.fjnu.springboot.bean.Information;
import org.fjnu.springboot.mapper.InfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-06-13 16:19
 */
@Service
public class InfoService {

    @Resource
    InfoMapper infoMapper;

    public List<Information> SelectAll(){
        return infoMapper.SelectAll();
    }

    public Integer SelectByCount(){
        return infoMapper.SelectByCount();
    }

    public Information SelectById(String cno){
        return infoMapper.SelectById(cno);
    }

    public void InsertByInformation(Information information){
        infoMapper.InsertByInformation(information);
    }
}
