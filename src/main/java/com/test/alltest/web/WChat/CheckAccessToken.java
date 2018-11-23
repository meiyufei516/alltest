package com.test.alltest.web.WChat;

import com.test.alltest.config.CashClass;
import com.test.alltest.schedule.AutoGetAccessToken;
import com.test.alltest.util.LogTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class CheckAccessToken {

    private static final Logger logger= LoggerFactory.getLogger(CheckAccessToken.class);
    /**
     * 检查access_token是否为空
     * @return
     */
    public static int  checkAccessToken(){
        if(StringUtils.isEmpty(CashClass.access_token)){
            //如果access_token是空的就要去获取一次
            AutoGetAccessToken autoGetAccessToken=new AutoGetAccessToken();
            try {
                autoGetAccessToken.autoGetAccessToken();
            }catch (Exception e){
                logger.error("【"+ LogTime.getLogTime()+"】获取access_token时Https访问失败："+e.getMessage());
                return 1;
            }
        }
        return 0;
    }
}
