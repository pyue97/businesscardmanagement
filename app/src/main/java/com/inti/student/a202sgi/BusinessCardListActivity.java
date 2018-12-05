package com.inti.student.a202sgi;

import android.support.v4.app.Fragment;

public class BusinessCardListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new BusinessCardListFragment();
    }
}
