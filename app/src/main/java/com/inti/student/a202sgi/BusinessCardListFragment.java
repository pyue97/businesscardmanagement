package com.inti.student.a202sgi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BusinessCardListFragment extends Fragment {
    private SQLiteDatabase mDatabase;
    private RecyclerView mRecyclerView;
    private BusinessCardAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bs_list, container, false);

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        mDatabase = dbHelper.getReadableDatabase();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new BusinessCardAdapter(getContext(), getAllItems());
        mRecyclerView.setAdapter(mAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                removeItem((long) viewHolder.itemView.getTag());
            }
        }).attachToRecyclerView(mRecyclerView);

        return view;
    }

    private void removeItem(long id) {
        mDatabase.delete(BusinessCard.BusinessCardEntry.TABLE_NAME,
                BusinessCard.BusinessCardEntry.COL_1 + "=" + id, null);
        mAdapter.swapCursor(getAllItems());
    }

    private Cursor getAllItems() {
        return mDatabase.query(
                BusinessCard.BusinessCardEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                BusinessCard.BusinessCardEntry.COL_2 + " ASC");
    }
}
