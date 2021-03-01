package com.accp.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.accp.domain.Consumer;
import com.accp.service.IConsumerService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dsy
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    IConsumerService zz;
    @RequestMapping("/selectPage")
    @ResponseBody
    public List<Consumer> select(String kehu){
        System.out.println("查询条件"+kehu);
        QueryWrapper<Consumer> query =  new QueryWrapper<>();
        if (kehu!=null){
            query.lambda().like(Consumer::getKhName,kehu);
        }
        List<Consumer> list = zz.list(query);
        System.out.println("用户"+list);
        return list;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public boolean insert(@RequestBody Consumer user){
        return zz.save(user);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updata(@RequestBody Consumer user){
        return zz.updateById(user);
    }

    @RequestMapping("delect")
    @ResponseBody
    public boolean delect(int id){
        return zz.removeById(id);
    }
}

