package com.ruoyi.wrms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.wrms.common.QueryPageParam;
import com.ruoyi.wrms.common.Result;
import com.ruoyi.wrms.pojo.Menu;
import com.ruoyi.wrms.pojo.User;
import com.ruoyi.wrms.service.MenuService;
import com.ruoyi.wrms.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "用户接口管理", description = "用户相关的接口")
public class UserController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    //通过no找信息,歪路,因为写登录返回值是布尔类型，session存储的信息不全所以需要这个方法来找全信息
    @PostMapping("/get")
    public User get(@RequestBody HashMap<String, String> params) {
        String no = params.get("no");
        if (no == null) {
            System.out.println("请求体中未找到 'no' 参数");
            return null;
        }
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getNo, no);
        System.out.println("查询条件: " + wrapper.getSqlSegment());
        User user = userService.getOne(wrapper);
        if (user == null) {
            System.out.println("未找到匹配的数据，no: " + no);
        } else {
            System.out.println("找到的数据: " + user);
        }
        return user;
    }
    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User user1 = userService.login(user);
        if (user1 == null){
            return Result.fail();
        }else {
            List<Menu> menuslist = menuService.lambdaQuery().like(Menu::getMenuRight, user1.getRoleId()).list();
            HashMap res = new HashMap();
            res.put("user",user1);
            res.put("menu", menuslist);
            return Result.success(res);
        }
    }
    //展示
    @GetMapping("/list")
    public List<User> list(){
       return userService.listAll();
    }
    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }
    //更新
    @PostMapping("/update")
    public boolean update(@RequestBody User user){
        return userService.updateById(user);
    }
    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.updateById(user);
    }
    //删除
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){
        return userService.removeById(id);
    }
    //查询
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(user.getName())) {
            lambdaQueryWrapper.like(User::getName, user.getName().trim());
        }
        Integer sex = user.getSex();
        System.out.println(sex);
        if (sex != null && sex != 0) {
            lambdaQueryWrapper.eq(User::getSex, sex);
        }
        int roleId = user.getRoleId();
        if (roleId != 0) {
            lambdaQueryWrapper.eq(User::getRoleId, roleId);
        }
        return userService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        HashMap<String, Object> param = query.getParams();
        String name = (String) param.get("name");
        Integer pageNum = query.getPageNum();
        Integer pageSize = query.getPageSize();

        Page<User> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            lambdaQueryWrapper.like(User::getName, name);
        }

        IPage<User> userPage = userService.page(page, lambdaQueryWrapper);

        return Result.success(userPage);
    }
    //修改账户启用状态
    @PostMapping("/change")
    public boolean change(@RequestBody User user){
        String isValid = user.getIsValid();
        System.out.println(isValid);
        // 检查 isValid 是否为 null 或 "Y"
        if ("Y".equals(isValid)){
            user.setIsValid("N");
        } else {
            user.setIsValid("Y");
        }

        return userService.updateById(user);
    }

}
