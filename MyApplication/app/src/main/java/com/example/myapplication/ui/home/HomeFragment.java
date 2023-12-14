package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupObservers(homeViewModel);

        return root;
    }

    private void setupObservers(HomeViewModel homeViewModel){

        final EditText insTitleEditText = binding.insTitle;
        homeViewModel.getInsTitle().observe(getViewLifecycleOwner(), insTitleEditText::setText);

        final EditText insHighEditText = binding.insHigh;
        homeViewModel.getInsHigh().observe(getViewLifecycleOwner(), insHighEditText::setText);

        final TextView titleTextView = binding.Title;
        homeViewModel.getTitleText().observe(getViewLifecycleOwner(), titleTextView::setText);

        final TextView highTextView = binding.High;
        homeViewModel.getHighText().observe(getViewLifecycleOwner(), highTextView::setText);

        final CheckBox isAAACheckBox = binding.isAAA;
        isAAACheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> homeViewModel.setIsAAA(isChecked));
        homeViewModel.getIsAAA().observe(getViewLifecycleOwner(), isAAACheckBox::setChecked);

        final CheckBox isSteamRedeemCheckBox = binding.isSteamRedeem;
        isSteamRedeemCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> homeViewModel.setIsSteamRedeem(isChecked));
        homeViewModel.getIsSteamRedeem().observe(getViewLifecycleOwner(), isSteamRedeemCheckBox::setChecked);

        final CheckBox isOnSaleCheckBox = binding.isOnSale;
        isOnSaleCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> homeViewModel.setIsOnSale(isChecked));
        homeViewModel.getIsOnSale().observe(getViewLifecycleOwner(), isOnSaleCheckBox::setChecked);

        final ImageButton searchButton = binding.searchButton;

        searchButton.setOnClickListener(v ->{
            Log.d("HomeFragment", "Button clicked directly");
            String title = insTitleEditText.getText().toString();
            String high = insHighEditText.getText().toString();
            Boolean AAA = homeViewModel.getIsAAA().getValue() != null ? homeViewModel.getIsAAA().getValue() : false;
            Boolean Steam = homeViewModel.getIsSteamRedeem().getValue() != null ? homeViewModel.getIsSteamRedeem().getValue() : false;
            Boolean OnSale = homeViewModel.getIsOnSale().getValue() != null ? homeViewModel.getIsOnSale().getValue() : false;

            if(!high.isEmpty()){
                try {
                    int Maxi = Integer.parseInt(high);
                    Log.d("HomeFragment", "AAA Value: " + AAA+"Onsale Value:"+ OnSale);
                    navigateToSearchResultFragment(title, Maxi, AAA, Steam, OnSale);


                }
                catch(NumberFormatException e){
                    e.printStackTrace();
                    // Show an error message when the input is not a valid integer
                    insHighEditText.setError("Please enter a valid integer");
                }
            }
            else{
                Log.d("HomeFragment", "AAA Value: " + AAA + "Onsale Value"+OnSale);
                navigateToSearchResultFragment(title,50,AAA,Steam,OnSale);
            }
        });

    }

    private void navigateToSearchResultFragment(String title, int high, boolean AAA, boolean Steam, boolean OnSale) {
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        bundle.putInt("high",high);
        bundle.putBoolean("AAA",AAA);
        bundle.putBoolean("Steam",Steam);
        bundle.putBoolean("OnSale",OnSale);

        NavHostFragment.findNavController(this).navigate(R.id.action_nav_home_to_searchResultFragment,bundle);
        /*
        SearchResultFragment searchResultFragment= new SearchResultFragment();
        searchResultFragment.setArguments(bundle);

        getParentFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, searchResultFragment)
                .addToBackStack(null)
                .commit();
        */
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}