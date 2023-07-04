package com.progetto_dd.memory.personaggio.incantesimo;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
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
public final class IncantesimoDao_Impl implements IncantesimoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Incantesimo> __insertionAdapterOfIncantesimo;

  private final EntityInsertionAdapter<Incantesimo> __insertionAdapterOfIncantesimo_1;

  private final EntityDeletionOrUpdateAdapter<Incantesimo> __deletionAdapterOfIncantesimo;

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
        if (value.getClassi() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getClassi());
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
        if (value.getClassi() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getClassi());
        }
        if (value.getInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getInfo());
        }
      }
    };
    this.__deletionAdapterOfIncantesimo = new EntityDeletionOrUpdateAdapter<Incantesimo>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tabella_incantesimi` WHERE `nome` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Incantesimo value) {
        if (value.getNome() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNome());
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

  @Override
  public Object delete(final Incantesimo incantesimo,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfIncantesimo.handle(incantesimo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getIncantesimiByParams(final int livello, final String tipo, final String classe,
      final String classeConcatenata, final Continuation<? super List<Incantesimo>> continuation) {
    final String _sql = "SELECT * FROM tabella_incantesimi WHERE livello = ? AND tipo = ? AND (classi = ? OR classi LIKE ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, livello);
    _argIndex = 2;
    if (tipo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipo);
    }
    _argIndex = 3;
    if (classe == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classe);
    }
    _argIndex = 4;
    if (classeConcatenata == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classeConcatenata);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Incantesimo>>() {
      @Override
      public List<Incantesimo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfLivello = CursorUtil.getColumnIndexOrThrow(_cursor, "livello");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfClassi = CursorUtil.getColumnIndexOrThrow(_cursor, "classi");
          final int _cursorIndexOfInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "info");
          final List<Incantesimo> _result = new ArrayList<Incantesimo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Incantesimo _item;
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final int _tmpLivello;
            _tmpLivello = _cursor.getInt(_cursorIndexOfLivello);
            final String _tmpTipo;
            if (_cursor.isNull(_cursorIndexOfTipo)) {
              _tmpTipo = null;
            } else {
              _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
            }
            final String _tmpClassi;
            if (_cursor.isNull(_cursorIndexOfClassi)) {
              _tmpClassi = null;
            } else {
              _tmpClassi = _cursor.getString(_cursorIndexOfClassi);
            }
            final String _tmpInfo;
            if (_cursor.isNull(_cursorIndexOfInfo)) {
              _tmpInfo = null;
            } else {
              _tmpInfo = _cursor.getString(_cursorIndexOfInfo);
            }
            _item = new Incantesimo(_tmpNome,_tmpLivello,_tmpTipo,_tmpClassi,_tmpInfo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getIncantesimiByLevelAndClass(final int livello, final String classi,
      final String classiConcatenata, final Continuation<? super List<Incantesimo>> continuation) {
    final String _sql = "SELECT * FROM tabella_incantesimi WHERE livello = ? AND (classi = ? OR classi LIKE ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, livello);
    _argIndex = 2;
    if (classi == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classi);
    }
    _argIndex = 3;
    if (classiConcatenata == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classiConcatenata);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Incantesimo>>() {
      @Override
      public List<Incantesimo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfLivello = CursorUtil.getColumnIndexOrThrow(_cursor, "livello");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfClassi = CursorUtil.getColumnIndexOrThrow(_cursor, "classi");
          final int _cursorIndexOfInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "info");
          final List<Incantesimo> _result = new ArrayList<Incantesimo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Incantesimo _item;
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final int _tmpLivello;
            _tmpLivello = _cursor.getInt(_cursorIndexOfLivello);
            final String _tmpTipo;
            if (_cursor.isNull(_cursorIndexOfTipo)) {
              _tmpTipo = null;
            } else {
              _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
            }
            final String _tmpClassi;
            if (_cursor.isNull(_cursorIndexOfClassi)) {
              _tmpClassi = null;
            } else {
              _tmpClassi = _cursor.getString(_cursorIndexOfClassi);
            }
            final String _tmpInfo;
            if (_cursor.isNull(_cursorIndexOfInfo)) {
              _tmpInfo = null;
            } else {
              _tmpInfo = _cursor.getString(_cursorIndexOfInfo);
            }
            _item = new Incantesimo(_tmpNome,_tmpLivello,_tmpTipo,_tmpClassi,_tmpInfo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getIncantesimiByTypeAndClass(final String tipo, final String classi,
      final String classiConcatenata, final Continuation<? super List<Incantesimo>> continuation) {
    final String _sql = "SELECT * FROM tabella_incantesimi WHERE tipo = ? AND (classi = ? OR classi LIKE ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (tipo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipo);
    }
    _argIndex = 2;
    if (classi == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classi);
    }
    _argIndex = 3;
    if (classiConcatenata == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classiConcatenata);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Incantesimo>>() {
      @Override
      public List<Incantesimo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfLivello = CursorUtil.getColumnIndexOrThrow(_cursor, "livello");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfClassi = CursorUtil.getColumnIndexOrThrow(_cursor, "classi");
          final int _cursorIndexOfInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "info");
          final List<Incantesimo> _result = new ArrayList<Incantesimo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Incantesimo _item;
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final int _tmpLivello;
            _tmpLivello = _cursor.getInt(_cursorIndexOfLivello);
            final String _tmpTipo;
            if (_cursor.isNull(_cursorIndexOfTipo)) {
              _tmpTipo = null;
            } else {
              _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
            }
            final String _tmpClassi;
            if (_cursor.isNull(_cursorIndexOfClassi)) {
              _tmpClassi = null;
            } else {
              _tmpClassi = _cursor.getString(_cursorIndexOfClassi);
            }
            final String _tmpInfo;
            if (_cursor.isNull(_cursorIndexOfInfo)) {
              _tmpInfo = null;
            } else {
              _tmpInfo = _cursor.getString(_cursorIndexOfInfo);
            }
            _item = new Incantesimo(_tmpNome,_tmpLivello,_tmpTipo,_tmpClassi,_tmpInfo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getIncantesimiByClass(final String classi, final String classiConcatenata,
      final Continuation<? super List<Incantesimo>> continuation) {
    final String _sql = "SELECT * FROM tabella_incantesimi WHERE (classi = ? OR classi LIKE ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (classi == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classi);
    }
    _argIndex = 2;
    if (classiConcatenata == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, classiConcatenata);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Incantesimo>>() {
      @Override
      public List<Incantesimo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfLivello = CursorUtil.getColumnIndexOrThrow(_cursor, "livello");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfClassi = CursorUtil.getColumnIndexOrThrow(_cursor, "classi");
          final int _cursorIndexOfInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "info");
          final List<Incantesimo> _result = new ArrayList<Incantesimo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Incantesimo _item;
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final int _tmpLivello;
            _tmpLivello = _cursor.getInt(_cursorIndexOfLivello);
            final String _tmpTipo;
            if (_cursor.isNull(_cursorIndexOfTipo)) {
              _tmpTipo = null;
            } else {
              _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
            }
            final String _tmpClassi;
            if (_cursor.isNull(_cursorIndexOfClassi)) {
              _tmpClassi = null;
            } else {
              _tmpClassi = _cursor.getString(_cursorIndexOfClassi);
            }
            final String _tmpInfo;
            if (_cursor.isNull(_cursorIndexOfInfo)) {
              _tmpInfo = null;
            } else {
              _tmpInfo = _cursor.getString(_cursorIndexOfInfo);
            }
            _item = new Incantesimo(_tmpNome,_tmpLivello,_tmpTipo,_tmpClassi,_tmpInfo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getIncantesimoByNome(final String nomeIncantesimo,
      final Continuation<? super Incantesimo> continuation) {
    final String _sql = "SELECT * FROM tabella_incantesimi WHERE nome = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nomeIncantesimo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nomeIncantesimo);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Incantesimo>() {
      @Override
      public Incantesimo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfLivello = CursorUtil.getColumnIndexOrThrow(_cursor, "livello");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfClassi = CursorUtil.getColumnIndexOrThrow(_cursor, "classi");
          final int _cursorIndexOfInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "info");
          final Incantesimo _result;
          if(_cursor.moveToFirst()) {
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final int _tmpLivello;
            _tmpLivello = _cursor.getInt(_cursorIndexOfLivello);
            final String _tmpTipo;
            if (_cursor.isNull(_cursorIndexOfTipo)) {
              _tmpTipo = null;
            } else {
              _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
            }
            final String _tmpClassi;
            if (_cursor.isNull(_cursorIndexOfClassi)) {
              _tmpClassi = null;
            } else {
              _tmpClassi = _cursor.getString(_cursorIndexOfClassi);
            }
            final String _tmpInfo;
            if (_cursor.isNull(_cursorIndexOfInfo)) {
              _tmpInfo = null;
            } else {
              _tmpInfo = _cursor.getString(_cursorIndexOfInfo);
            }
            _result = new Incantesimo(_tmpNome,_tmpLivello,_tmpTipo,_tmpClassi,_tmpInfo);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
