package com.example.pigsinapenteam2;

import java.util.LinkedList;

/**
 * ChainFinder: remembers the set of "chains" present on the board,
 *  and provides helper functions for counting/measuring/finding them.
 */
public class ChainFinder {
  private LinkedList<Chain> chains;
  private ChainMap chainMap;

  

  public ChainFinder() {
    chains = new LinkedList<>();
    chainMap = new ChainMap();
  }

  public ChainFinder(BoardState state) {
    chains = new LinkedList<>();
    chainMap = new ChainMap(state);
  }

  public void findChains() {

  }

  private void growChainHead(Chain chain) {

  }

  private void growChainTail(Chain chain) {

  }

  private void growChainHeadRecursive(Chain toGrow, int[] currentCell, int[] previousCell) {

  }

  private void growChainTailRecursive(Chain toGrow, int[] currentCell, int[] previousCell) {

  }

  /**
   * sortChains(): uses insertion sort to sort chains in ascending order by length.
   */
  private void sortChains() {
    //implements insertion sort
    Chain keyChain;
    Chain iChain;
    int iValue;
    int key;
    int i;
    if (chains.size() > 1) {
      for (int j = 1; j < chains.size(); j++) {
        keyChain = chains.get(j);
        key = keyChain.length;
        i = j - 1;
        iChain = chains.get(i);
        iValue = iChain.length;
        while ((i >= 0) && (iValue > key)) {
          chains.set(i + 1, iChain);
          i = i - 1;
          if (i >= 0) {
            iChain = chains.get(i);
            iValue = iChain.length;
          }
        }
        chains.set(i + 1, keyChain);
      }
    }
  }

  public LinkedList<Chain> getChains() {
    return chains;
  }
}
