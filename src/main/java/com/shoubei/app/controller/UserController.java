package com.shoubei.app.controller;

import com.shoubei.app.domain.User;
import com.shoubei.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户列表
     * @return List<User>
     */
    @GetMapping(value = "/user")
    public List<User>  userList() {
        return userRepository.findAll();
    }

    /**
     * 添加一个用户
     * @param name
     * @param phone
     * @param level
     * @return User
     */
    @PostMapping(value = "/user")
    public User userAdd(@RequestParam("name") String name,
                           @RequestParam("phone") String phone,
                           @RequestParam("level") String level) {

        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setLevel(level);

        return userRepository.save(user);
    }

    //查询一个用户
    @GetMapping(value = "/user/{id}")
    public User userQuery(@PathVariable("id") Integer id) {

        return userRepository.findOne(id);
    }

    //修改一个用户
    @PutMapping(value = "/user/{id}")
    public User userUpdate(@PathVariable("id") Integer id,
                              @RequestParam("name") String name,
                              @RequestParam("phone") String phone,
                              @RequestParam("level") String level) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        user.setLevel(level);

        return userRepository.save(user);

    }

    //删除一个用户
    @DeleteMapping(value = "/user/{id}")
    public void userDelete(@PathVariable("id") Integer id) {
        userRepository.delete(id);

    }

    //通过level查找用户
    @GetMapping(value = "/user/level/{level}")
    public List<User> userListByLevel(@PathVariable("level") String level) {

        return userRepository.findByLevel(level);

    }

}
