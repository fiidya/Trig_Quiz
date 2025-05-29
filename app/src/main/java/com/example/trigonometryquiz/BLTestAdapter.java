package com.example.trigonometryquiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BLTestAdapter extends RecyclerView.Adapter<BLTestAdapter.QuestionViewHolder> {

    private List<Question> questionList;

    public BLTestAdapter(List<Question> questions) {
        Collections.shuffle(questions);
        this.questionList = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question q = questionList.get(position);
        holder.questionText.setText(q.getText());
        holder.radioGroup.removeAllViews();

        RadioButton[] radioButtons = new RadioButton[q.getOptions().length];

        for (int i = 0; i < q.getOptions().length; i++) {
            RadioButton rb = new RadioButton(holder.itemView.getContext());
            rb.setText(q.getOptions()[i]);
            holder.radioGroup.addView(rb);
            radioButtons[i] = rb;
        }

        holder.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            for (RadioButton rb : radioButtons) {
                rb.setEnabled(false);
                if (rb.getId() == checkedId) {
                    if (rb.getText().equals(q.getAnswer())) {
                        rb.setTextColor(0xFF008000);
                    } else {
                        rb.setTextColor(0xFFFF0000);
                    }
                } else if (rb.getText().equals(q.getAnswer())) {
                    rb.setTextColor(0xFF008000);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    static class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView questionText;
        RadioGroup radioGroup;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.question_text);
            radioGroup = itemView.findViewById(R.id.answer_group);
        }
    }
}
