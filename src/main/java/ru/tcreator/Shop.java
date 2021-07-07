package ru.tcreator;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop implements Runnable {
  protected int[] shopProceeds;
  protected LongAdder bankAcc;

  public Shop(LongAdder bankAccumulator) {
    this.bankAcc = bankAccumulator;
    shopProceeds = new int[10];
    Random rand = new Random();
    for (int i = 0; i < shopProceeds.length; i++) {
      shopProceeds[i] = rand.nextInt(1000000);
    }

  }

  @Override
  public void run() {
    long proceeds = Arrays.stream(shopProceeds).sum();
    System.out.println(Thread.currentThread().getName() + " отправил: " + proceeds);
    bankAcc.add(proceeds);
  }
}
