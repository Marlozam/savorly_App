package com.example.savorly.ui.savedlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.savorly.databinding.FragmentSavedlistBinding;

public class SavedlistFragment extends Fragment {

    private FragmentSavedlistBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Use this to get the Fragment as the ViewModelStoreOwner
        SavedlistViewModel SavedlistViewModel =
                new ViewModelProvider(this).get(SavedlistViewModel.class);

        binding = FragmentSavedlistBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}