package cn.z.jiutian.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("b")
public class B extends Chain<OrderVo> {

    private static final Logger LOG = LoggerFactory.getLogger(B.class);
    
    @Override
    protected void next(OrderVo condition) {
        LOG.info("------------B------------");
        
        if(getNext() != null ){
            getNext().next(condition);
        }
    }
    

}
