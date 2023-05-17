package com.progetto_dd.memory.personaggio;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.progetto_dd.utils.Converters;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CompetenzaDao_Impl implements CompetenzaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Competenza> __insertionAdapterOfCompetenza;

  private final Converters __converters = new Converters();

  private final EntityInsertionAdapter<Competenza> __insertionAdapterOfCompetenza_1;

  public CompetenzaDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCompetenza = new EntityInsertionAdapter<Competenza>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tabella_competenze` (`nome`,`classi_competenza`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Competenza value) {
        if (value.getNome() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNome());
        }
        final String _tmp = __converters.toString(value.getClassi());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
      }
    };
    this.__insertionAdapterOfCompetenza_1 = new EntityInsertionAdapter<Competenza>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tabella_competenze` (`nome`,`classi_competenza`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Competenza value) {
        if (value.getNome() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNome());
        }
        final String _tmp = __converters.toString(value.getClassi());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
      }
    };
  }

  @Override
  public Object insertOrReplace(final Competenza competenza,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCompetenza.insert(competenza);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertAll(final List<Competenza> competenze,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCompetenza_1.insert(competenze);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public List<String> getCompetenzeNomiByClasse(final String classe) {
    final String _sql = "SELECT nome FROM tabella_competenze WHERE classi_competenza LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (classe == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classe);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getString(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
