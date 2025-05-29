package com.example.trigonometryquiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.Collections;
import java.util.List;

public class QuestionFragment extends Fragment {

    private static final String ARG_CATEGORY = "category";
    private String category;

    public static QuestionFragment newInstance(String category) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    public QuestionFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = getArguments().getString(ARG_CATEGORY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ScrollView scrollView = new ScrollView(getContext());
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        List<Question> questions = QuestionRepository.getQuestionsByCategory(category);
        Collections.shuffle(questions);
        List<Question> selectedQuestions = questions.subList(0, Math.min(5, questions.size()));

        for (Question q : selectedQuestions) {
            TextView tv = new TextView(getContext());
            tv.setText(q.getText());
            tv.setTextSize(18);
            tv.setPadding(0, 16, 0, 4);
            layout.addView(tv);

            RadioGroup group = new RadioGroup(getContext());
            for (String opt : q.getOptions()) {
                RadioButton rb = new RadioButton(getContext());
                rb.setText(opt);
                group.addView(rb);
            }
            layout.addView(group);
        }

        scrollView.addView(layout);
        return scrollView;
    }
}
