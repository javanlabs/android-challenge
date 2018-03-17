package id.resurrect.androidchallenge.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.resurrect.androidchallenge.R;
import id.resurrect.androidchallenge.model.Commits;
import id.resurrect.androidchallenge.utility.ItemListener;

/**
 * Created by Yoga Agung Kurnia on 3/17/2018.
 */

public class CommitAdapter extends RecyclerView.Adapter<CommitAdapter.CommitViewHolder>{

    private List<Commits> commitsList;
    private Context context;
    private ItemListener listener;

    public CommitAdapter(Context context, List<Commits> commitsList, ItemListener itemListener){
        this.context = context;
        this.commitsList = commitsList;
        this.listener = itemListener;
    }
    @Override
    public CommitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_commits, parent, false);
        return new CommitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommitViewHolder holder, int position) {
          holder.bindData(commitsList.get(position),position, listener);
    }

    @Override
    public int getItemCount() {
        return commitsList.size();
    }

    public static class CommitViewHolder extends RecyclerView.ViewHolder{
        TextView number;
        TextView code;
        TextView commiter;
        TextView message;

        public CommitViewHolder(View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.text_number);
            code = itemView.findViewById(R.id.text_code_commit);
            commiter = itemView.findViewById(R.id.text_commiter);
            message = itemView.findViewById(R.id.text_message_commit);
        }

        void bindData(final Commits commits, int pos, final ItemListener listener){
            String sha = commits.getSha().substring(0,7);
            number.setText("#"+(pos+1));
            code.setText(sha);
            commiter.setText(commits.getCommitter().getLogin());
            message.setText(commits.getCommit().getMessage());
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    listener.onItemClick(commits);
                }
            });
        }

    }
}
