package com.example.myapplication.ui.home;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.myapplication.DEAL;
import com.example.myapplication.R;

public class DetailsFragment extends Fragment {
    private DetailsViewModel viewModel;
    public static final String ARG_GAME_DETAILS = "arg_game_details";

    public DetailsFragment(){

    }

    public static DetailsFragment newInstance(DEAL gameDetails){
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_GAME_DETAILS,gameDetails);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (viewModel == null) {
            viewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);

        ImageView thumbnailImageView = view.findViewById(R.id.thumbnailImageView);
        TextView titleTextView = view.findViewById(R.id.titleTextView);
        TextView normalPriceTextView = view.findViewById(R.id.normalpriceTextView);
        TextView salePriceTextView = view.findViewById(R.id.salepriceTextView);
        TextView metaScoreTextView = view.findViewById(R.id.metacriticTextView);
        TextView steamReviewsCountTextView = view.findViewById(R.id.steamratingcountTextView);
        TextView steamReviewsPercentTextView = view.findViewById(R.id.steamratingpercentTextView);
        TextView steamRatingTextTextView = view.findViewById(R.id.steamratingtextTextView);
        TextView releaseDateTextView = view.findViewById(R.id.releasedateTextView);
        TextView dealRatingTextView = view.findViewById(R.id.dealratingTextView);

        ImageButton gobuythisbutton = view.findViewById(R.id.gobuythisbutton);
        gobuythisbutton.setOnClickListener(v -> openWebPage());

        viewModel.getGameDetails().observe(getViewLifecycleOwner(),gameDetails ->{
            if(gameDetails != null){
                Glide.with(requireContext()).load(gameDetails.getThumb()).into(thumbnailImageView);
                titleTextView.setText(gameDetails.getTitle());
                normalPriceTextView.setText(gameDetails.getNormalPrice());
                normalPriceTextView.setPaintFlags(normalPriceTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                salePriceTextView.setText(gameDetails.getSalePrice());
                metaScoreTextView.setText(gameDetails.getMetacriticScore());
                steamReviewsCountTextView.setText(gameDetails.getSteamRatingCount());
                steamReviewsPercentTextView.setText(gameDetails.getSteamRatingPercent()+"%");
                steamRatingTextTextView.setText(gameDetails.getSteamRatingText());
                releaseDateTextView.setText(gameDetails.getReleaseDate());
                dealRatingTextView.setText(gameDetails.getDealRating());;
            }
        });



        return view;
    }

    private void openWebPage(){

        DEAL gameDetails = getArguments().getParcelable(ARG_GAME_DETAILS);

        if (gameDetails != null){
            String dealId = gameDetails.getDealID();
            String url = "https://www.cheapshark.com/redirect?dealID="+dealId;

            Log.d("DetailsFragment", "Opening web page: " + url);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivity(intent);
            }else{
                Toast.makeText(requireContext(), "No app found to handle the web page.", Toast.LENGTH_SHORT).show();
            }
        } else{
            Log.e("DetailsFragment", "Game details is null");
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // You can move the viewModel initialization to onViewCreated
        viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
    }
}


