package com.example.trigonometryquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BLTestsFragment extends Fragment {
    private RecyclerView recyclerView;
    private BLTestAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bl_tests, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Button Btn1 = rootView.findViewById(R.id.Addition);
        Button Btn2 = rootView.findViewById(R.id.HalfAngle);
        Button Btn3 = rootView.findViewById(R.id.DoubleAngle);
        Button Btn4 = rootView.findViewById(R.id.SumToProduct);
        Button Btn5 = rootView.findViewById(R.id.ProductToSum);
        Button Btn6 = rootView.findViewById(R.id.TripleAngle);
        Button Btn7 = rootView.findViewById(R.id.Subtraction);
        Button Btn8 = rootView.findViewById(R.id.Reduction);

        Btn1.setOnClickListener(v -> loadQuestions("1"));
        Btn2.setOnClickListener(v -> loadQuestions("2"));
        Btn3.setOnClickListener(v -> loadQuestions("3"));
        Btn4.setOnClickListener(v -> loadQuestions("4"));
        Btn5.setOnClickListener(v -> loadQuestions("5"));
        Btn6.setOnClickListener(v -> loadQuestions("6"));
        Btn7.setOnClickListener(v -> loadQuestions("7"));
        Btn8.setOnClickListener(v -> loadQuestions("8"));

        return rootView;
    }

    private void loadQuestions(String category) {
        List<Question> questions = QuestionRepository.getQuestionsByCategory(category);
        adapter = new BLTestAdapter(questions);
        recyclerView.setAdapter(adapter);
    }
}
