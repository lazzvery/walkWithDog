package com.prj.web.awesome.item.mapper;

import com.prj.web.awesome.item.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper {
    List<ItemDto> itemList(String ctgr_cd);
}
