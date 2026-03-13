package io.github.oliviercailloux.contracts;

public class Multiplier {
  private static int operand1;
  private static int operand2;
  private static String mode = "general";

  public static void setGeneralMode() {
    mode = "general";
  }

  public static void setPositiveMode() {
    mode = "positive";
  }

  public static void setPositiveResultMode() {
    mode = "positiveResult";
  }

  public static void setFirstOperand(int operand) {
    if (mode.equals("positive") && operand <= 0) {
      throw new IllegalStateException("Operand must be positive in positive mode.");
    }
    operand1 = operand;
  }

  public static void setSecondOperand(int operand) {
    if (mode.equals("positive") && operand <= 0) {
      throw new IllegalStateException("Operand must be positive in positive mode.");
    }
    operand2 = operand;
  }

  public static int multiply() {
    int result = operand1 * operand2;
    if (mode.equals("positive") && result <= 0) {
      throw new IllegalStateException("Result must be positive in positive mode.");
    }
    if (mode.equals("positiveResult") && result < 0) {
      throw new IllegalStateException("Result must be positive in positive result mode.");
    }
    return result;
  }

  public static void main(String[] args) {
    setFirstOperand(3);
    setSecondOperand(4);
    if (mode.equals("positive")) {
      setPositiveMode();
    } 
    if (mode.equals("positiveResult")) {
      setPositiveResultMode();
    }
    if (mode.equals("general")) {}
      setGeneralMode();
    }
    System.out.println(multiply());
  }
}
