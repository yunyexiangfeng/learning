package com.design_pattern.proxy.javadynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Administrator
 * @CreateDate: 2020/9/30 16:55
 */
public class MachinePrinter implements IPrinter {
    private final static Logger LOG = LoggerFactory.getLogger(MachinePrinter.class);
    @Override
    public void print() {
        LOG.info("Machine is always work.");
        throw new NullPointerException("test after exception throw");
    }
}
