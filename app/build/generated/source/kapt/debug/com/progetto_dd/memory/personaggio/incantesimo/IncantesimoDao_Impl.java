package com.progetto_dd.memory.personaggio.incantesimo;

import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.progetto_dd.utils.Converters;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IncantesimoDao_Impl implements IncantesimoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Incantesimo> __insertionAdapterOfIncantesimo;

  private final Converters __converters = new Converters();

  private final EntityInsertionAdapter<Incantesimo> __insertionAdapterOfIncantesimo_1;

  public IncantesimoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIncantesimo = new EntityInsertionAdapter<Incantesimo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tabella_incantesimi` (`nome`,`livello`,`tipo`,`classi`,`info`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Incantesimo value) {
        if (value.getNome() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNome());
        }
        stmt.bindLong(2, value.getLivello());
        if (value.getTipo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTipo());
        }
        final String _tmp = __converters.toString(value.getClassi());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        if (value.getInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getInfo());
        }
      }
    };
    this.__insertionAdapterOfIncantesimo_1 = new EntityInsertionAdapter<Incantesimo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tabella_incantesimi` (`nome`,`livello`,`tipo`,`classi`,`info`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Incantesimo value) {
        if (value.getNome() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNome());
        }
        stmt.bindLong(2, value.getLivello());
        if (value.getTipo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTipo());
        }
        final String _tmp = __converters.toString(value.getClassi());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        if (value.getInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getInfo());
        }
      }
    };
  }

  @Override
  public Object insertOrReplace(final Incantesimo incantesimo,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfIncantesimo.insert(incantesimo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertAll(final List<Incantesimo> incantesimo,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfIncantesimo_1.insert(incantesimo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
