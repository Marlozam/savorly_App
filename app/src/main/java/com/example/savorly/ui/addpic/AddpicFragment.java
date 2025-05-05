package com.example.savorly.ui.addpic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.savorly.databinding.FragmentAddpicBinding;

public class AddpicFragment extends Fragment{
    private FragmentAddpicBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Use this to get the Fragment as the ViewModelStoreOwner
        AddpicViewModel AddpicViewModel =
                new ViewModelProvider(this).get(AddpicViewModel.class);

        binding = FragmentAddpicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
