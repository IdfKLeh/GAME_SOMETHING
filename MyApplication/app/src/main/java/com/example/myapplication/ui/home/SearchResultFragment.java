package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DEAL;
import com.example.myapplication.R;
import com.example.myapplication.cheapshark;
import com.example.myapplication.cheapsharkapiclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultFragment extends Fragment implements GameViewHolder.OnGameItemClickListener{

    private SearchResultViewModel viewModel;
    private GameAdapter gameAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_search_result, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        gameAdapter = new GameAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(gameAdapter);

        viewModel = new ViewModelProvider(this).get(SearchResultViewModel.class);

        Bundle arguments = getArguments();
        if(arguments!=null){
            String title = arguments.getString("title","");
            int high = arguments.getInt("high",0);
            boolean AAA = arguments.getBoolean("AAA",false);
            boolean Steam = arguments.getBoolean("Steam",false);
            boolean OnSale = arguments.getBoolean("OnSale",false);

            makeApiCall(title,high,AAA,Steam,OnSale);
        }


        viewModel.getSearchResults().observe(getViewLifecycleOwner(), gameAdapter::setGames);

        return root;
    }

    @Override
    public void onGameItemClick(int position){
        DEAL selectedGame = gameAdapter.getGameAt(position);

        if(selectedGame != null) {
            navigateToDetailsFragment(selectedGame);
        }
    }

    private void navigateToDetailsFragment(DEAL game){
        DetailsViewModel detailsViewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);

        detailsViewModel.setGameDetails(game);

        Log.d("Navigation", "Navigating to DetailsFragment");
        Bundle bundle = new Bundle();
        bundle.putParcelable(DetailsFragment.ARG_GAME_DETAILS,game);

        Navigation.findNavController(requireView()).navigate(
                R.id.action_searchResultFragment_to_detailsFragment,
                bundle
        );
    }

    private void makeApiCall(String title, int high, boolean AAA, boolean Steam, boolean OnSale){
        cheapshark cheapShark = cheapsharkapiclient.create();
        int aaaValue = AAA ? 1 : 0;
        int steamValue = Steam ? 1:0;
        int onsaleValue = OnSale ? 1:0;

        Call<List<DEAL>> call = cheapShark.getDeals(title,high,aaaValue,steamValue,onsaleValue);

        call.enqueue(new Callback<List<DEAL>>(){
            @Override
            public void onResponse(Call<List<DEAL>> call, Response<List<DEAL>> response){
                if(response.isSuccessful()){
                    List<DEAL> deals = response.body();
                    Log.d("API Response", "Number of deals received: " + deals.size());
                    for (DEAL deal : deals) {
                        Log.d("Deal", "Title: " + deal.getTitle());
                    }

                    // Update the ViewModel with the new search results

                    viewModel.setSearchResults(deals);
                }
                else {
                    Log.e("API Error", "Error: " + response.code());

                }
            }
            @Override
            public void onFailure(Call<List<DEAL>> call, Throwable t){
                Log.e("API Failure", "Failed to make API call", t);
            }
        });
    }
}
