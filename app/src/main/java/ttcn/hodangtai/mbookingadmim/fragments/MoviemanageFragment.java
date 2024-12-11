package ttcn.hodangtai.mbookingadmim.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ttcn.hodangtai.mbookingadmim.R;
import ttcn.hodangtai.mbookingadmim.viewmodels.MoviemanageViewModel;

public class MoviemanageFragment extends Fragment {

    private MoviemanageViewModel mViewModel;

    public static MoviemanageFragment newInstance() {
        return new MoviemanageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_moviemanage, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MoviemanageViewModel.class);
        // TODO: Use the ViewModel
    }

}