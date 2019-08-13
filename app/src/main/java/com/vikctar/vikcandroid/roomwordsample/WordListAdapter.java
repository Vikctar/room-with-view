package com.vikctar.vikcandroid.roomwordsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemTextView;

        WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemTextView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;

    private List<Word> mWords; // cached copy of mWords

    WordListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return  new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.wordItemTextView.setText(current.getWord());
        } else {
            holder.wordItemTextView.setText(R.string.no_word);
        }

    }

    void setmWords(List<Word> Words) {
        mWords = Words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mWords == null ? 0 : mWords.size();
    }
}
