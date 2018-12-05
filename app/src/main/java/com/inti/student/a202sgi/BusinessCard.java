package com.inti.student.a202sgi;

import android.provider.BaseColumns;

public class BusinessCard {

    private BusinessCard() {}

    public static final class BusinessCardEntry implements BaseColumns {
        public static final String TABLE_NAME = "businesscard_table";
        public static final String COL_1 = "ID";
        public static final String COL_2 = "FIRST_NAME";
        public static final String COL_3 = "LAST_NAME";
        public static final String COL_4 = "CONTACT_NO";
        public static final String COL_5 = "EMAIL";
        public static final String COL_6 = "JOB_TITLE";
        public static final String COL_7 = "COMPANY_NAME";
        public static final String COL_8 = "COMPANY_ADDRESS";
        public static final String COL_9 = "COMPANY_URL";
    }
}
