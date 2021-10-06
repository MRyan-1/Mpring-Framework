package org.mryan.context.test.beans;

import org.mryan.beans.factory.annotation.Autowired;
import org.mryan.beans.factory.annotation.Component;
import org.mryan.beans.factory.annotation.Value;

import java.util.Random;

/**
 * @description： 注解测试Service
 * @Author MRyan
 * @Date 2021/10/6 19:42
 * @Version 1.0
 */
@Component("annotationService")
public class AnnotationService implements IAnnotationService {

    /**
     * 占位符注入属性信息 @Value("${token}") 注入
     */
    @Value("${token}")
    private String token;

    /**
     * 注入对象信息 @Autowired
     */
    @Autowired
    private AnnotationDao annotationDao;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return annotationDao.queryUserName("1") + "，" + token;
    }

}
