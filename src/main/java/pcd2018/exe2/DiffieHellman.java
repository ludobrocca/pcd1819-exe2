package pcd2018.exe2;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Classe da completare per l'esercizio 2.
 */
public class DiffieHellman {

  /**
   * Limite massimo dei valori segreti da cercare
   */
  private static final int LIMIT = 65536;

  private final long p;
  private final long g;


  public DiffieHellman(long p, long g) {
    this.p = p;
    this.g = g;
  }


  /**
   * Metodo da completare
   *
   * @param publicA valore di A
   * @param publicB valore di B
   * @return tutte le coppie di possibili segreti a,b
   */
  public List<Integer> crack(long publicA, long publicB) {
    List<Integer> res = new ArrayList<Integer>();



      HashMap<Integer, Long> Ahashmap = new HashMap<>(
              IntStream.rangeClosed(0, LIMIT)
                      .parallel()
                      .boxed()
                      .collect(
                              Collectors.toMap(x-> x, x-> DiffieHellmanUtils.modPow(publicB, x, p))
                      )
      );



      HashMap<Integer,Long> Bhasmap = new HashMap<>(
              IntStream.rangeClosed(0,LIMIT)
                      .parallel()
                      .boxed()
                      .collect(
                                Collectors.toMap(x-> x, x-> DiffieHellmanUtils.modPow(publicA,x,p))
              )


      );

      Ahashmap.entrySet().parallelStream().forEach(x-> {

          Integer[] values=Bhasmap.entrySet()
                  .parallelStream()
                  .filter(z -> z.getValue().equals(x.getValue()))
                  .map(Map.Entry::getKey)
                  .toArray(Integer[]::new);

          Arrays.stream(values).parallel().forEach(el -> synchroAdd(res,x.getKey(),el));

      });

    return res;
  }


    public synchronized void synchroAdd(List<Integer> res,Integer a,Integer b) {
      res.add(a);
      res.add(b);
    }



}
