package com.inti.student.a202sgi;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BusinessCardAdapter extends RecyclerView.Adapter<BusinessCardAdapter.BusinessCardViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public BusinessCardAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public class BusinessCardViewHolder extends RecyclerView.ViewHolder {
        public TextView firstName;
        public TextView lastName;
        public TextView contactNo;
        public TextView email;
        public TextView jobTitle;
        public TextView companyName;
        public TextView companyAddress;
        public TextView companyURL;

        public BusinessCardViewHolder(View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.tv_fName);
            lastName = itemView.findViewById(R.id.tv_lName);
            contactNo = itemView.findViewById(R.id.tv_ContactNo);
            email = itemView.findViewById(R.id.tv_Email);
            jobTitle = itemView.findViewById(R.id.tv_JobTitle);
            companyName = itemView.findViewById(R.id.tv_CompanyName);
            companyAddress = itemView.findViewById(R.id.tv_CompanyAdd);
            companyURL = itemView.findViewById(R.id.tv_CompanyURL);
        }
    }

    @Override
    public BusinessCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_bs, parent, false);
        return new BusinessCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BusinessCardViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        long id = mCursor.getLong(mCursor.getColumnIndex(BusinessCard.BusinessCardEntry.COL_1));
        String f_Name = mCursor.getString(mCursor.getColumnIndex(BusinessCard.BusinessCardEntry.COL_2));
        String l_Name = mCursor.getString(mCursor.getColumnIndex(BusinessCard.BusinessCardEntry.COL_3));
        String contact_No = mCursor.getString(mCursor.getColumnIndex(BusinessCard.BusinessCardEntry.COL_4));
        String email = mCursor.getString(mCursor.getColumnIndex(BusinessCard.BusinessCardEntry.COL_5));
        String job_Title = mCursor.getString(mCursor.getColumnIndex(BusinessCard.BusinessCardEntry.COL_6));
        String comp_Name = mCursor.getString(mCursor.getColumnIndex(BusinessCard.BusinessCardEntry.COL_7));
        String comp_Address = mCursor.getString(mCursor.getColumnIndex(BusinessCard.BusinessCardEntry.COL_8));
        String comp_URL = mCursor.getString(mCursor.getColumnIndex(BusinessCard.BusinessCardEntry.COL_9));

        holder.itemView.setTag(id);
        holder.firstName.setText(f_Name);
        holder.lastName.setText(l_Name);
        holder.contactNo.setText(contact_No);
        holder.email.setText(email);
        holder.jobTitle.setText(job_Title);
        holder.companyName.setText(comp_Name);
        holder.companyAddress.setText(comp_Address);
        holder.companyURL.setText(comp_URL);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}