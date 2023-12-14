// SearchResultViewModel.java
package com.example.myapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.DEAL;

import java.util.List;

public class SearchResultViewModel extends ViewModel {

    private final MutableLiveData<List<DEAL>> searchResults = new MutableLiveData<>();

    public LiveData<List<DEAL>> getSearchResults() {
        return searchResults;
    }
    public void setSearchResults(List<DEAL> results) {
        searchResults.setValue(results);
    }

    // Add methods for fetching search results from the API, updating LiveData, etc.
    // You can use a repository pattern or other architectural patterns for better organization.
}
