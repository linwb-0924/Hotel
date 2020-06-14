package org.fjnu.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fjnu.springboot.bean.Room;

import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-06-13 10:01
 */
@Mapper
public interface RoomMapper {

    List<Room> SelectAll();

    Integer SelectByCount();

    Room SelectById(String rno);

    void InsertByRoom(Room room);
    List<Room> SelectByEmpty();

    void UpdateByRno(String rno);
}
