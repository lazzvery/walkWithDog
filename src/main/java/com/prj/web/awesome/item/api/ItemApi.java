package com.prj.web.awesome.item.api;

import com.prj.web.awesome.item.controller.ItemController;
import com.prj.web.awesome.item.payload.in.ItemInPayload;
import com.prj.web.awesome.item.payload.out.ItemOutPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
@Log4j2
public class ItemApi {

    private final ItemController controller;

    /**
     * Get은 Html 단순 호출
     * */
    @GetMapping("/list")
    public ModelAndView getResultView() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("html/itemList/itemList");

        return mv;
    }

    /**
     *  Post는 Jquery에서 POST 로 호출하여 리스트를 조회해옴
     *
     * @Param : inDs
     * @Return : itemOutPayload
     * */
    @PostMapping("/list")
    public ItemOutPayload getItemList(@RequestBody ItemInPayload inDs) {
        ItemOutPayload itemOutPayload = new ItemOutPayload();

        itemOutPayload.setItemOutArr(controller.itemList(inDs.getItemInDto()));

        return itemOutPayload;
    }
}