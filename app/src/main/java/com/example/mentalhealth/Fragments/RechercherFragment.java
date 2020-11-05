package com.example.mentalhealth.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mentalhealth.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RechercherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RechercherFragment extends Fragment {

    private RecyclerView recyclerView;


    public RechercherFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_rechercher, container, false);

        recyclerView = view.findViewById(R.id.userSearchRecycler);
    }
}