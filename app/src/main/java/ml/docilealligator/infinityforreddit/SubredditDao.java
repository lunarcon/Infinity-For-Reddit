package ml.docilealligator.infinityforreddit;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

@Dao
public interface SubredditDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SubredditData SubredditData);

    @Query("DELETE FROM subreddits")
    void deleteAllSubreddits();

    @Query("SELECT * from subreddits WHERE id = :id")
    LiveData<SubredditData> getSubreddit(String id);
}
