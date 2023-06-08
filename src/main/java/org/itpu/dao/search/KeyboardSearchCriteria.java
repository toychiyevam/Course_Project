package org.itpu.dao.search;

import bean.Keyboard;

public class KeyboardSearchCriteria extends AbstractCriteria<Keyboard>  {

    @Override
    public Class<Keyboard> getApplianceType() {
        return Keyboard.class;
    }
}
