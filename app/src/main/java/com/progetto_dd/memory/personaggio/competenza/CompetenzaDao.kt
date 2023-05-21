package com.progetto_dd.memory.personaggio.competenza

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CompetenzaDao {

    // Inserisce o sostituisce una competenza nel database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(competenza: Competenza)

    // Inserisce una lista di competenze nel database
    @Insert
    suspend fun insertAll(competenze: List<Competenza>)


    //Controlla se la tabella delle competenze è vuota. true se la tabella è vuota, false altrimenti
    @Query("SELECT COUNT(*) FROM tabella_competenze")
    suspend fun isCompetenzeTableEmpty(): Boolean


    /*
     La query con LIKE '%' || :classe || '%' cerca tutti i record in cui il valore della colonna
     classi_competenza contiene il parametro classe come parte della stringa, indipendentemente dai
     caratteri che lo precedono o seguono. Ad esempio, se classe è "guerriero", la query restituirà
     tutti i record in cui la colonna classi_competenza contiene la parola "guerriero" come parte
     della stringa, come ad esempio "guerriero1", "classe_guerriero", "competenza_guerriero", ecc.
     */
    @Query("SELECT nome FROM tabella_competenze WHERE classi_competenza LIKE '%' || :classe || '%'")
    fun getCompetenzeNomiByClasse(classe: String): List<String>

}