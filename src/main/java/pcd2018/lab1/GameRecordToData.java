package pcd2018.lab1;

import java.util.function.Function;

import pcd2018.lab1.bowling.BowlingGame;
import pcd2018.lab1.bowling.GameRecord;
import pcd2018.lab1.data.DataRecord;

/**
 * Trasforma un record letto dal file in un record di dati da riassumere.
 */
public class GameRecordToData implements Function<GameRecord, DataRecord> {

  private final Function<GameRecord, String> keyExtractor;

  public GameRecordToData(Function<GameRecord, String> keyExtractor) {
    this.keyExtractor = keyExtractor;
  }

  @Override
  public DataRecord apply(GameRecord t) {
    BowlingGame game= new BowlingGame(t.score);
    return new DataRecord(keyExtractor.apply(t),game.score(),game.strikes(),game.spares(),game.gutters());
  }

}
