package lcdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FirstBean implements InitializingBean, SmartLifecycle {
    protected final Log logger = LogFactory.getLog(getClass());

    private SecondBean secondBean;
    private boolean isRunning = false;

    @Autowired
    public FirstBean(SecondBean secondBean) {
        logger.debug("FirstBean@" + System.identityHashCode(this) + "(" + secondBean + ") constructed");
        this.secondBean = secondBean;
    }

    public void setSecondBean() {
        logger.debug("FirstBean#setSecondBean(" + secondBean + ") called");
    }

    @PostConstruct
    public void postConstruct() {
        logger.debug(getClass().getSimpleName() + "@" + System.identityHashCode(this) + ".postConstruct()");
    }


    @Override
    public String toString() {
        return "FirstBean@" + System.identityHashCode(this) + "{" +
                "secondBean=" + secondBean +
                '}';
    }

    public void init() {
        logger.debug(getClass().getSimpleName() + "@" + System.identityHashCode(this) + ".init()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug(getClass().getSimpleName() + "@" + System.identityHashCode(this) + ".afterPropertiesSet()");
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        logger.debug(getClass().getSimpleName() + "@" + System.identityHashCode(this) + ".stop(" + callback + ")");
        callback.run();
    }

    @Override
    public void start() {
        logger.debug(getClass().getSimpleName() + "@" + System.identityHashCode(this) + ".start()");
        isRunning = true;
    }

    @Override
    public void stop() {
        logger.debug(getClass().getSimpleName() + "@" + System.identityHashCode(this) + ".stop()");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
