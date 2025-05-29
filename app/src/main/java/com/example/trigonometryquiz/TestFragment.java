package com.example.trigonometryquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;
import java.util.*;

public class TestFragment extends Fragment {

    private static final List<Question> allQuestions = Arrays.asList(
            new Question("Формула для синуса суммы углов?", "sin(α) cos(β) + cos(α) sin(β)",
                    new String[]{"cos(α) cos(β) - sin(α) sin(β)", "(tgα + tgβ)/(1 - tgα tgβ)", "sin(α) cos(β) + cos(α) sin(β)"}),

            new Question("Формула приведения для sin(π/2 - α)?", "cos(α)",
                    new String[]{"sin(α)", "tg(α)", "cos(α)"}),

            new Question("Какая из следующих формул тангенс двойного угла?", "2tan(a)/(1 - tan²(a))",
                    new String[]{"sin(2a)/cos(2a)", "2tan(a)/(1 - tan²(a))", "tan²(a)/(1 - 2tan(a))"}),

            new Question("Что выражает формула sin(2α) = 2sin(α)cos(a)?", "Синус двойного угла",
                    new String[]{"Синус двойного угла", "Косинус двойного угла", "Произведение синусов"}),

            new Question("Формула косинуса разности углов?", "cos(α) cos(β) - sin(α) sin(β)",
                    new String[]{"cos(α) cos(β) + cos(α) cos(β)", "cos(α) cos(β) - sin(α) sin(β)", "sin(α) sin(β) - cos(α) cos(β)"}),

            new Question("tg(π/2 - α) = ?", "ctg(α)",
                    new String[]{"tg(α)", "ctg(α)", "-ctg(α)"}),

            new Question("Формула косинуса двойного угла?", "cos²(α) - sin²(α)",
                    new String[]{"2cos²(α) - 1", "cos²(α) - sin²(α)", "1 - 2sin²(α)"}),

            new Question("Что такое ctg(α)?", "cos(α) / sin(α)",
                    new String[]{"cos(α) / sin(α)", "sin(α) / cos(α)", "1 / sin(α)"}),

            new Question("Формула приведения для cos(π - α)?", "-cos(α)",
                    new String[]{"-cos(α)", "cos(α)", "-sin(α)"}),

            new Question("Синус суммы углов?", "sin(α) cos(β) + cos(α) sin(β)",
                    new String[]{"cos(α) cos(β) - sin(α) sin(β)", "sin(α) cos(β) + cos(α) sin(β)", "cos(α) sin(β) - sin(α) cos(β)"}),

            new Question("Формула синуса тройного угла?", "3sin(a) - 4sin³(a)",
                    new String[]{"3sin(a) - 4sin³(a)", "4cos³(a) - 3cos(a)", "sin(a) / (1 - cos(a))"}),

            new Question("Формула для cos(α + β)?", "cos(α)cos(β) − sin(α)sin(β)",
                    new String[]{"cos(α)cos(β) + sin(α)sin(β)", "cos(α)cos(β) − sin(α)sin(β)", "cos(α + β)"}),

            new Question("Чему равен sin(π − α)?", "sin(α)",
                    new String[]{"-sin(α)", "cos(α)", "sin(α)"}),

            new Question("Формула для tan(α + β)?", "(tan(α) + tan(β)) / (1 − tan(α)tan(β))",
                    new String[]{"(tan(α) − tan(β)) / (1 + tan(α)tan(β))", "(tan(α) + tan(β)) / (1 − tan(α)tan(β))", "tan(α + β)"}),

            new Question("cos(π/2 − α) = ?", "sin(α)",
                    new String[]{"−cos(α)", "sin(α)", "−sin(α)"}),

            new Question("Формула приведения для sin(π − α)?", "sin(α)",
                    new String[]{"−sin(α)", "cos(α)", "sin(α)"}),

            new Question("Формула косинуса суммы углов?", "cos(α + β) = cos(α)cos(β) − sin(α)sin(β)",
                    new String[]{"cos(α + β) = cos(α)cos(β) + sin(α)sin(β)", "cos(α + β) = cos(α)cos(β) − sin(α)sin(β)", "cos(α + β) = sin(α)sin(β) − cos(α)cos(β)"}),

            new Question("Чему равен sin(−α)?", "−sin(α)",
                    new String[]{"sin(α)", "−sin(α)", "cos(α)"}),

            new Question("Чему равен cos(−α)?", "cos(α)",
                    new String[]{"−cos(α)", "cos(α)", "−sin(α)"}),

            new Question("tg(π + α) = ?", "tg(α)",
                    new String[]{"−tg(α)", "tg(α)", "ctg(α)"})
    );

    private List<Question> selectedQuestions;
    private List<RadioGroup> radioGroups = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_test, container, false);
        LinearLayout layout = root.findViewById(R.id.tests_container);
        Button finishBtn = root.findViewById(R.id.finish_button);

        Collections.shuffle(allQuestions);
        selectedQuestions = allQuestions.subList(0, 7);

        for (Question q : selectedQuestions) {
            TextView tvQ = new TextView(getContext());
            tvQ.setText("Вопрос: " + q.getText());
            tvQ.setTextSize(18);
            tvQ.setTextColor(Color.BLACK);
            layout.addView(tvQ);

            RadioGroup rg = new RadioGroup(getContext());
            rg.setOrientation(RadioGroup.VERTICAL);
            for (String opt : q.getOptions()) {
                RadioButton rb = new RadioButton(getContext());
                rb.setText(opt);
                rb.setTextColor(Color.BLACK);
                rg.addView(rb);
            }
            layout.addView(rg);
            radioGroups.add(rg);

            Space space = new Space(getContext());
            space.setMinimumHeight(16);
            layout.addView(space);
        }

        finishBtn.setOnClickListener(v -> {
            int correctCount = 0;
            for (int i = 0; i < selectedQuestions.size(); i++) {
                Question q = selectedQuestions.get(i);
                RadioGroup rg = radioGroups.get(i);
                int checkedId = rg.getCheckedRadioButtonId();

                int selectedIndex = -1;
                if (checkedId != -1) {
                    View checked = rg.findViewById(checkedId);
                    selectedIndex = rg.indexOfChild(checked);
                }

                int correctIndex = -1;
                String[] opts = q.getOptions();
                for (int j = 0; j < opts.length; j++) {
                    if (opts[j].equals(q.getAnswer())) {
                        correctIndex = j;
                        break;
                    }
                }

                if (selectedIndex != -1 && selectedIndex == correctIndex) {
                    correctCount++;
                }

                for (int j = 0; j < rg.getChildCount(); j++) {
                    RadioButton rb = (RadioButton) rg.getChildAt(j);
                    rb.setEnabled(false);
                    if (j == correctIndex) {
                        rb.setTextColor(Color.GREEN);
                    } else if (j == selectedIndex) {
                        rb.setTextColor(Color.RED);
                    }
                }
            }

            Toast.makeText(getContext(),
                    "Правильных ответов: " + correctCount + " из " + selectedQuestions.size(),
                    Toast.LENGTH_LONG).show();

            finishBtn.setEnabled(false);
        });
        return root;
    }
}
