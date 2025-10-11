package com.leetcode.other;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        scanner.close();

        // 分割方程为左右两边
        String[] parts = equation.split("=");
        String left = parts[0];
        String right = parts[1];

        // 解析左右两边，获取系数和常数
        Expression leftExp = parseExpression(left);
        Expression rightExp = parseExpression(right);

        // 移项: 左边未知数系数 - 右边未知数系数
        double coefficient = leftExp.coefficient - rightExp.coefficient;
        // 移项: 右边常数 - 左边常数
        double constant = rightExp.constant - leftExp.constant;

        // 计算解
        double solution = constant / coefficient;
        // 处理-0.000的情况
        if (Math.abs(solution) < 1e-9) {
            solution = 0;
        }

        // 输出结果，保留三位小数
        System.out.printf("%c=%.3f\n", leftExp.variable, solution);
    }

    // 表示表达式的系数和常数
    static class Expression {
        char variable;
        double coefficient;
        double constant;
    }

    // 解析表达式，返回系数和常数
    private static Expression parseExpression(String expr) {
        Expression exp = new Expression();
        exp.coefficient = 0;
        exp.constant = 0;

        // 查找变量
        for (char c : expr.toCharArray()) {
            if (Character.isLowerCase(c)) {
                exp.variable = c;
                break;
            }
        }

        // 在表达式开头添加+号，方便统一处理
        expr = "+" + expr;
        // 使用正则表达式分割成项
        String[] terms = expr.split("(?=[+-])");

        for (String term : terms) {
            if (term.isEmpty()) continue;

            // 处理每一项
            if (term.contains(String.valueOf(exp.variable))) {
                // 处理未知数项
                String coeffStr = term.replace(String.valueOf(exp.variable), "");
                double coeff;

                if (coeffStr.isEmpty() || coeffStr.equals("+")) {
                    coeff = 1;
                } else if (coeffStr.equals("-")) {
                    coeff = -1;
                } else {
                    coeff = Double.parseDouble(coeffStr);
                }

                exp.coefficient += coeff;
            } else {
                // 处理常数项
                if (!term.equals("+") && !term.equals("-")) {
                    exp.constant += Double.parseDouble(term);
                }
            }
        }

        return exp;
    }
}
