package org.itpu.dao.search;

import bean.Monitor;

public class MonitorSearchCriteria extends AbstractCriteria<Monitor>  {

    @Override
    public Class<Monitor> getApplianceType() {
        return Monitor.class;
    }
}
