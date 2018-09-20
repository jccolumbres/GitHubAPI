package testapp.jccolumbres.githubapi.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import testapp.jccolumbres.githubapi.R;
import testapp.jccolumbres.githubapi.model.GitHubRepo;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {
    private List<GitHubRepo> repos;
    private int rowlayout;
    private Context ctx;

    public RepoAdapter(List<GitHubRepo> repos, int rowlayout, Context ctx) {
        this.setRepos(repos);
        this.setRowlayout(rowlayout);
        this.setCtx(ctx);
    }

    public List<GitHubRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GitHubRepo> repos) {
        this.repos = repos;
    }

    public int getRowlayout() {
        return rowlayout;
    }

    public void setRowlayout(int rowlayout) {
        this.rowlayout = rowlayout;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(rowlayout,parent,false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.name.setText(repos.get(position).getRepoName());
        holder.desc.setText(repos.get(position).getRepoDesc());
        holder.language.setText(repos.get(position).getRepoLanguage());

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        TextView name,desc,language;

        public RepoViewHolder(View v){
            super(v);
            linearLayout = (LinearLayout)v.findViewById(R.id.repo_item_layout);
            name = (TextView)v.findViewById(R.id.tvRepoName);
            desc = (TextView)v.findViewById(R.id.tvRepoDesc);
            language = (TextView)v.findViewById(R.id.tvRepoLanguage);
        }

    }
}
