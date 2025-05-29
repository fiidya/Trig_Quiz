package com.example.trigonometryquiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionRepository {

    private static final Map<String, List<Question>> questionsByCategory = new HashMap<>();

    static {
        List<Question> Addition = new ArrayList<>();
        Addition.add(new Question("Формула для sin(α + β)?", "sin(α)cos(β) + cos(α)sin(β)",
                new String[]{"sin(α)cos(β) + cos(α)sin(β)", "sin(α)cos(β) - cos(α)sin(β)", "cos(α)cos(β) - sin(α)sin(β)"}));
        Addition.add(new Question("Формула для cos(α + β)?", "cos(α)cos(β) - sin(α)sin(β)",
                new String[]{"cos(α)cos(β) - sin(α)sin(β)", "cos(α)cos(β) + sin(α)sin(β)", "sin(α)cos(β) - cos(α)sin(β)"}));
        Addition.add(new Question("Формула для tg(α + β)?", "(tg(α) + tg(β)) / (1 - tg(α)tg(β))",
                new String[]{"(tg(α) + tg(β)) / (1 - tg(α)tg(β))", "(tg(α) - tg(β)) / (1 + tg(α)tg(β))", "(tg(α) + tg(β)) / (1 + tg(α)tg(β))"}));
        Addition.add(new Question("Формула для ctg(α + β)?", "(ctg(α)ctg(β) - 1) / (ctg(α) + ctg(β))",
                new String[]{"(ctg(α)ctg(β) - 1) / (ctg(α) + ctg(β))", "(ctg(α) + ctg(β)) / (1 - ctg(α)ctg(β))", "(ctg(α)ctg(β) + 1) / (ctg(α) - ctg(β))"}));
        Addition.add(new Question("Формула преобразования sin(α + β)?", "sin(α)cos(β) + cos(α)sin(β)",
                new String[]{"sin(α)cos(β) + cos(α)sin(β)", "cos(α)cos(β) - sin(α)sin(β)", "cos(α)cos(β) + sin(α)sin(β)"}));
        questionsByCategory.put("1", Addition);

        List<Question> HalfAngle = new ArrayList<>();
        HalfAngle.add(new Question("Формула для sin(α/2)?", "±√((1 - cos(α))/2)",
                new String[]{"±√((1 - cos(α))/2)", "±√((1 + cos(α))/2)", "±√((1 - sin(α))/2)"}));
        HalfAngle.add(new Question("Формула для cos(α/2)?", "±√((1 + cos(α))/2)",
                new String[]{"±√((1 + cos(α))/2)", "±√((1 - cos(α))/2)", "±√((1 + sin(α))/2)"}));
        HalfAngle.add(new Question("Формула для tg(α/2)?", "±√((1 - cos(α))/(1 + cos(α)))",
                new String[]{"±√((1 - cos(α))/(1 + cos(α)))", "±√((1 + cos(α))/(1 - cos(α)))", "±√((1 + sin(α))/(1 - sin(α)))"}));
        HalfAngle.add(new Question("Формула для ctg(α/2)?", "±√((1 + cos(α))/(1 - cos(α)))",
                new String[]{"±√((1 + cos(α))/(1 - cos(α)))", "±√((1 - cos(α))/(1 + cos(α)))", "±√((1 - sin(α))/(1 + sin(α)))"}));
        HalfAngle.add(new Question("Формула для tg(α/2) через sin и cos?", "sin(α) / (1 + cos(α))",
                new String[]{"sin(α) / (1 + cos(α))", "cos(α) / (1 + sin(α))", "sin(α) / (1 - cos(α))"}));
        questionsByCategory.put("2", HalfAngle);

        List<Question> DoubleAngle = new ArrayList<>();
        DoubleAngle.add(new Question("Формула для sin(2α)?", "2sin(α)cos(α)",
                new String[]{"2sin(α)cos(α)", "sin²(α) + cos²(α)", "2sin²(α)"}));
        DoubleAngle.add(new Question("Формула для cos(2α)?", "cos²(α) - sin²(α)",
                new String[]{"cos²(α) - sin²(α)", "cos²(α) + sin²(α)", "2cos²(α) - 1"}));
        DoubleAngle.add(new Question("Формула для tg(2α)?", "2tg(α)/(1 - tg²(α))",
                new String[]{"2tg(α)/(1 - tg²(α))", "tg²(α) + 2", "tg(α)/(1 + tg²(α))"}));
        DoubleAngle.add(new Question("Формула для cos(2α) через sin²?", "1 - 2sin²(α)",
                new String[]{"1 - 2sin²(α)", "1 + 2sin²(α)", "2sin²(α) - 1"}));
        DoubleAngle.add(new Question("Формула для cos(2α) через cos²?", "2cos²(α) - 1",
                new String[]{"2cos²(α) - 1", "1 - 2cos²(α)", "2cos²(α) + 1"}));
        questionsByCategory.put("3", DoubleAngle);

        List<Question> SumToProduct = new ArrayList<>();
        SumToProduct.add(new Question("Формула для sin(α) + sin(β)?", "2sin((α + β)/2)cos((α - β)/2)",
                new String[]{"2sin((α + β)/2)cos((α - β)/2)", "2cos((α + β)/2)sin((α - β)/2)", "sin((α + β)/2) + cos((α - β)/2)"}));
        SumToProduct.add(new Question("Формула для cos(α) + cos(β)?", "2cos((α + β)/2)cos((α - β)/2)",
                new String[]{"2cos((α + β)/2)cos((α - β)/2)", "2sin((α + β)/2)cos((α - β)/2)", "cos((α + β)/2) + sin((α - β)/2)"}));
        SumToProduct.add(new Question("Формула для sin(α) - sin(β)?", "2cos((α + β)/2)sin((α - β)/2)",
                new String[]{"2cos((α + β)/2)sin((α - β)/2)", "2sin((α + β)/2)cos((α - β)/2)", "2cos((α - β)/2)sin((α + β)/2)"}));
        SumToProduct.add(new Question("Формула для cos(α) - cos(β)?", "-2sin((α + β)/2)sin((α - β)/2)",
                new String[]{"-2sin((α + β)/2)sin((α - β)/2)", "2cos((α + β)/2)sin((α - β)/2)", "-2cos((α + β)/2)cos((α - β)/2)"}));
        SumToProduct.add(new Question("Формула преобразования суммы синусов?", "2sin((α + β)/2)cos((α - β)/2)",
                new String[]{"2sin((α + β)/2)cos((α - β)/2)", "sin(α) + sin(β)", "cos((α + β)/2) + sin((α - β)/2)"}));
        questionsByCategory.put("4", SumToProduct);

        List<Question> ProductToSum = new ArrayList<>();
        ProductToSum.add(new Question("Формула для sin(α)sin(β)?", "½[cos(α − β) − cos(α + β)]",
                new String[]{"½[cos(α − β) − cos(α + β)]", "cos(α + β)", "½[sin(α + β) + sin(α − β)]"}));
        ProductToSum.add(new Question("Формула для cos(α)cos(β)?", "½[cos(α − β) + cos(α + β)]",
                new String[]{"½[cos(α − β) + cos(α + β)]", "½[cos(α + β) - cos(α − β)]", "cos(α − β) + cos(α + β)"}));
        ProductToSum.add(new Question("Формула для sin(α)cos(β)?", "½[sin(α + β) + sin(α − β)]",
                new String[]{"½[sin(α + β) + sin(α − β)]", "sin(α + β)", "sin(α) + cos(β)"}));
        ProductToSum.add(new Question("Формула для cos(α)sin(β)?", "½[sin(α + β) − sin(α − β)]",
                new String[]{"½[sin(α + β) − sin(α − β)]", "sin(α − β)", "sin(α + β) + sin(α − β)"}));
        ProductToSum.add(new Question("Формула преобразования произведения косинусов?", "½[cos(α − β) + cos(α + β)]",
                new String[]{"½[cos(α − β) + cos(α + β)]", "½[cos(α − β) - cos(α + β)]", "cos(α + β)cos(α − β)"}));
        questionsByCategory.put("5", ProductToSum);

        List<Question> TripleAngle = new ArrayList<>();
        TripleAngle.add(new Question("Формула для sin(3α)?", "3sin(α) - 4sin³(α)",
                new String[]{"3sin(α) - 4sin³(α)", "3sin(α) + 4sin³(α)", "4sin³(α) - 3sin(α)"}));
        TripleAngle.add(new Question("Формула для cos(3α)?", "4cos³(α) - 3cos(α)",
                new String[]{"4cos³(α) - 3cos(α)", "3cos(α) - 4cos³(α)", "4cos(α) - 3cos³(α)"}));
        TripleAngle.add(new Question("Формула для tg(3α)?", "(3tg(α) - tg³(α)) / (1 - 3tg²(α))",
                new String[]{"(3tg(α) - tg³(α)) / (1 - 3tg²(α))", "(3tg(α) + tg³(α)) / (1 + 3tg²(α))", "(tg³(α) - 3tg(α)) / (3tg²(α) - 1)"}));
        TripleAngle.add(new Question("Формула для sin(3α) через sin?", "3sin(α) - 4sin³(α)",
                new String[]{"3sin(α) - 4sin³(α)", "4sin³(α) + 3sin(α)", "3sin(α) + 4sin³(α)"}));
        TripleAngle.add(new Question("Формула для cos(3α) через cos?", "4cos³(α) - 3cos(α)",
                new String[]{"4cos³(α) - 3cos(α)", "3cos(α) + 4cos³(α)", "4cos(α) - 3cos³(α)"}));
        questionsByCategory.put("6", TripleAngle);

        List<Question> Subtraction = new ArrayList<>();
        Subtraction.add(new Question("Формула для sin(α - β)?", "sin(α)cos(β) - cos(α)sin(β)",
                new String[]{"sin(α)cos(β) - cos(α)sin(β)", "sin(α)cos(β) + cos(α)sin(β)", "cos(α)cos(β) - sin(α)sin(β)"}));
        Subtraction.add(new Question("Формула для cos(α - β)?", "cos(α)cos(β) + sin(α)sin(β)",
                new String[]{"cos(α)cos(β) + sin(α)sin(β)", "cos(α)cos(β) - sin(α)sin(β)", "sin(α)cos(β) - cos(α)sin(β)"}));
        Subtraction.add(new Question("Формула для tg(α - β)?", "(tg(α) - tg(β)) / (1 + tg(α)tg(β))",
                new String[]{"(tg(α) - tg(β)) / (1 + tg(α)tg(β))", "(tg(α) + tg(β)) / (1 - tg(α)tg(β))", "(tg(α) - tg(β)) / (1 - tg(α)tg(β))"}));
        Subtraction.add(new Question("Формула для ctg(α - β)?", "(ctg(β)ctg(α) + 1) / (ctg(β) - ctg(α))",
                new String[]{"(ctg(β)ctg(α) + 1) / (ctg(β) - ctg(α))", "(ctg(α) - ctg(β)) / (1 + ctg(α)ctg(β))", "(ctg(α) + ctg(β)) / (1 - ctg(α)ctg(β))"}));
        Subtraction.add(new Question("Формула преобразования вычитания синусов?", "2cos((α + β)/2)sin((α - β)/2)",
                new String[]{"2cos((α + β)/2)sin((α - β)/2)", "2sin((α + β)/2)cos((α - β)/2)", "sin(α) - sin(β)"}));
        questionsByCategory.put("7", Subtraction);

        List<Question> Reduction = new ArrayList<>();
        Reduction.add(new Question("Формула приведения sin(π - α)?", "sin(α)",
                new String[]{"sin(α)", "-sin(α)", "cos(α)"}));
        Reduction.add(new Question("Формула приведения cos(π - α)?", "-cos(α)",
                new String[]{"-cos(α)", "cos(α)", "-sin(α)"}));
        Reduction.add(new Question("Формула приведения sin(π + α)?", "-sin(α)",
                new String[]{"-sin(α)", "sin(α)", "-cos(α)"}));
        Reduction.add(new Question("Формула приведения cos(π + α)?", "-cos(α)",
                new String[]{"-cos(α)", "cos(α)", "-sin(α)"}));
        Reduction.add(new Question("Формула приведения sin(-α)?", "-sin(α)",
                new String[]{"-sin(α)", "sin(α)", "-cos(α)"}));
        questionsByCategory.put("8", Reduction);
    }


    public static List<Question> getQuestionsByCategory(String category) {
        return questionsByCategory.getOrDefault(category, new ArrayList<>());
    }
}
