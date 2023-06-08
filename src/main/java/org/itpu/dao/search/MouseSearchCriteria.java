package org.itpu.dao.search;

import bean.Mouse;

public class MouseSearchCriteria extends AbstractCriteria<Mouse>  {

    @Override
    public Class<Mouse> getApplianceType() {
        return Mouse.class;
    }
}
