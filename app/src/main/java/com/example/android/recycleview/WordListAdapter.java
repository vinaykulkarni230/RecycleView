package com.example.android.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    abstract class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View   mItemView, WordListAdapter adapter) {
            super(mItemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }


    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mitemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mitemView, this) {
            @Override
            public void onClick(View view) {
                int mpPosition = getLayoutPosition();
                String element = mWordList.get(mpPosition);
                mWordList.set(mpPosition, "Clicked!" + element);
                mAdapter.notifyDataSetChanged();

                int mPosition = getLayoutPosition();
                element = mWordList.get(mPosition);
                mWordList.set(mPosition, "Clicked! " + element);
                mAdapter.notifyDataSetChanged();


            }
        };

    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();

    }
}


