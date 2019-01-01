/*package pcd2018.lab1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pcd2018.lab1.bowling.GameRecord;
import pcd2018.lab1.data.DataRecord;
import pcd2018.lab1.data.FinalRecord;
import pcd2018.lab1.solution.ReadScore;
import pcd2018.lab1.solution.Summarizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // Preparazione dei componenti
    BlockingQueue<GameRecord> inputQueue = new LinkedBlockingQueue<GameRecord>(1024 * 16);
    BlockingQueue<DataRecord> topPlayers = new LinkedBlockingQueue<DataRecord>(2048);
    BlockingQueue<DataRecord> topVenues = new LinkedBlockingQueue<DataRecord>(2048);


    // lettura dei file di input
    // Lettura dei file di input
    Stream<ReadScore> inputs = Stream
            .of("source-a.xz", "source-b.xz", "source-c.xz", "source-d.xz", "source-e.xz", "source-f.xz", "source-g.xz")
            .map((fileName) -> {
              ReadScore res;
              try {
                res = new ReadScore("src/main/resources/" + fileName, inputQueue);
              } catch (FileNotFoundException e) {
                e.printStackTrace();
                res = null;
              } catch (IOException e) {
                e.printStackTrace();
                res = null;
              }
              return res;
            });




    for(String path: paths){

      List<GameRecord> intermediate= Main.readFromPath(Paths.get(path));

      //concatenare
    }


    // TODO...

    // Trasformazione dei record letti

    // TODO...

    // Sommatoria secondo giocatori e piste

    Summarizer topPlayersSum = null;
    Summarizer topVenuesSum = null;

    // TODO...

    // Calcolo:
    // Top 10 giocatori (punteggio medio,partite giocate, strike totali, punteggio totale)
    // Top 10 piste (partite giocate, punteggio medio, strike totali, punteggio totale)

    System.out.println("Top players counting.");
    TreeSet<FinalRecord> strikes = entrydump(topPlayersSum.results().entrySet(), FinalRecord.AVGSTRIKES);
    System.out.println("Top venues counting.");
    TreeSet<FinalRecord> venues = entrydump(topVenuesSum.results().entrySet(), FinalRecord.AVGSCORE);
    entryprint(strikes, 10);
    System.out.println();
    entryprint(venues, 10);

    System.out.println("Games by players: " + entrySum(topPlayersSum.results().entrySet()));
    System.out.println("Games by venues: " + entrySum(topVenuesSum.results().entrySet()));

  }


  /** given a specific path, this files collects all the data, and for each lines creates a GameRecord object
   * @param source is the source Path
   * @return lists of gamerecords
   * @throws IOException
   */
/*
  public static List<GameRecord> readFromPath(Path source) throws IOException {

    if(Files.notExists(source))
    throw new IOException(source.toString() + " is an invalid path");

    if(!(Files.isReadable(source)))
      throw new IOException(source.toString() + " cannot the file in this path in read mode");


    List<String> lines= Files.readAllLines(source, Charset.defaultCharset());
    List<GameRecord> result = new ArrayList<GameRecord>();

    for(String line :lines){

      String [] res =line.split("|");

      GameRecord a= new GameRecord(res[0],res[1],Integer.parseInt(res[2]),res[3]);

      result.add(a);

    }

  return result;

  }





  /**
   * Calcola il totale delle partite giocate.
   * 
   * @param set
   * @return
   */

/*
  private static int entrySum(Set<Entry<String, int[]>> set) {
    int res = 0;
    for (Entry<String, int[]> e : set)
      res += e.getValue()[0];
    return res;
  }

  /**
   * Raccoglie tutti i risultati da una sorgente, li ordina e ritorna l'insieme ordinato.
   * 
   * @param source Sorgente di dati
   * @param comparator Comparatore
   * @return Elenco ordinato dei risultati
   */

/*
  static TreeSet<FinalRecord> entrydump(Set<Entry<String, int[]>> source, Comparator<FinalRecord> comparator) {
    TreeSet<FinalRecord> res = new TreeSet<FinalRecord>(comparator);
    for (Entry<String, int[]> e : source) {
      int[] val = e.getValue();
      res.add(new FinalRecord(e.getKey(), val[0], val[1], val[2], val[3], val[4]));
    }
    return res;
  }

  /**
   * Stampa dei record in modo leggibile.
   * 
   * @param source Sorgente dei dati
   * @param amount Quanti record stampare
   */
/*
  static void entryprint(TreeSet<FinalRecord> source, int amount) {
    Iterator<FinalRecord> iterator = source.iterator();
    for (int i = 0; i < amount && iterator.hasNext(); i++) {
      FinalRecord next = iterator.next();
      System.out.println(String.format("%d. %s %6d %6d %5d %5d %5d %7.5f %7.5f %7.5f %7.5f", i + 1, next.key,
          next.totgames, next.totscore, next.totstrikes, next.totspares, next.totgutters, next.avgscore,
          next.avgstrikes, next.avgspares, next.avggutters));
    }
  }

}
*/