package com.design_pattern.observer.observer;

import com.design_pattern.observer.subject.Subject;

/**
 * observer interface
 * Created by OY on 2019/11/11.
 */
public interface Observer {
    public void update(Subject subject);
}
