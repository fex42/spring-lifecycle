package lcdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SecondBean implements InitializingBean {
    protected final Log logger = LogFactory.getLog(getClass());

    private FirstBean firstBean;

    public SecondBean() {
        logger.debug("SecondBean@" + System.identityHashCode(this) + " constructed");
    }

    @Autowired
    public void setFirstBean(FirstBean firstBean) {
        logger.debug("SecondBean#setFirstBean(" + firstBean + ") called");
        this.firstBean = firstBean;
    }

    @PostConstruct
    public void postConstruct() {
        logger.debug(getClass().getSimpleName() + "@" + System.identityHashCode(this) + ".postConstruct()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug(getClass().getSimpleName() + "@" + System.identityHashCode(this) + ".afterPropertiesSet()");
    }

    @Override
    public String toString() {
        return "SecondBean@" + System.identityHashCode(this) + "{" +
                "firstBean=" + System.identityHashCode(firstBean) +
                '}';
    }
}
