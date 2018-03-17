package id.resurrect.androidchallenge;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import id.resurrect.androidchallenge.adapter.CommitAdapter;
import id.resurrect.androidchallenge.api.Client;
import id.resurrect.androidchallenge.api.Services;
import id.resurrect.androidchallenge.model.Commits;
import id.resurrect.androidchallenge.model.Repository;
import id.resurrect.androidchallenge.utility.ItemListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    TextView textRepository;
    TextView textAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.recyclerview_commit);
        textRepository = findViewById(R.id.text_repository);
        textAuthor= findViewById(R.id.text_author);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getDetailRepo();
        loadData();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDetailRepo();
                loadData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void getDetailRepo(){
        Services services = Client.getClient().create(Services.class);

        final Call<Repository> repositoryResponse = services.getDetailRepository();
        repositoryResponse.enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {
                Repository repository = response.body();
                textRepository.setText(repository.getName());
                textAuthor.setText(repository.getOwner().getLogin());
            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {

            }
        });
    }
    private void loadData(){
        Services services = Client.getClient().create(Services.class);

        Call<List<Commits>> commitResponse = services.getCommits();
        commitResponse.enqueue(new Callback<List<Commits>>() {
            @Override
            public void onResponse(Call<List<Commits>> call, Response<List<Commits>> response) {
                List<Commits> commitsList = response.body();
                recyclerView.setAdapter(new CommitAdapter(getApplicationContext(), commitsList, new ItemListener() {
                    @Override
                    public void onItemClick(Commits commits) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(commits.getHtmlUrl()));
                        startActivity(intent);
                    }
                }));

                Snackbar snackbar = Snackbar.make(swipeRefreshLayout,"Data Fetched", Snackbar.LENGTH_LONG);
                snackbar.show();
            }

            @Override
            public void onFailure(Call<List<Commits>> call, Throwable t) {
                Snackbar snackbar = Snackbar.make(swipeRefreshLayout, "No Internet Connection", Snackbar.LENGTH_LONG)
                        .setAction("Retry", new View.OnClickListener(){
                            @Override
                            public void onClick(View view) {
                                loadData();
                                getDetailRepo();
                            }
                        });
                snackbar.setActionTextColor(Color.CYAN);
                View viewSnackBar = snackbar.getView();
                TextView textView = viewSnackBar.findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                snackbar.show();
            }
        });
    }
}
