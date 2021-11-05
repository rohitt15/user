package com.developer.user.service;

import com.developer.user.entity.User;
import com.developer.user.repository.UserRepsitory;
import com.developer.user.valueobject.Department;
import com.developer.user.valueobject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepsitory userRepsitory;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside the save user of Service");
        return userRepsitory.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user=userRepsitory.findByUserId(userId);
        Department department=restTemplate.getForObject("localhost:9001/departments/" + user.getDepartmentId()
                ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
