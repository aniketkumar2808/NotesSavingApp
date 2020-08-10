package com.example.plainolnotes3;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;


import com.example.plainolnotes3.database.AppDatabase;
import com.example.plainolnotes3.database.NoteDao;
import com.example.plainolnotes3.database.NoteEntity;
import com.example.plainolnotes3.utilities.SampleData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG = "Junit";
    private AppDatabase mDb;
    private NoteDao mDao;

    @Before
    public void createDb(){
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context,
                AppDatabase.class).build();
        mDao = mDb.noteDao();
        Log.i(TAG,"createDb");
    }

    @After
    public void closeDb(){
        mDb.close();
        Log.i(TAG,"closeDb");

    }

    /*@Test
    public void createAndRetrieveNotes(){
        mDao.insertAll(SampleData.getNotes());
        //mDb.noteDao().insertAll(SampleData.getNotes());
        int count = mDao.getCount();
        Log.i(TAG,"createAndRetreiveNotes: count=" + count);
        assertEquals(SampleData.getNotes().size(),count);
    }*/

    @Test
    public void createAndRetrieveNotes1(){
        //mDao.insertAll(SampleData.getNotes());
        //mDb.noteDao().insertAll(SampleData.getNotes());
        mDao.insertNote(NoteEntity.);
        int count = mDao.getCount();
        Log.i(TAG,"createAndRetreiveNotes1: count1=" + count);
        assertEquals(SampleData.getNotes().size(),count);
    }

    /*@Test
    public void compareStrings(){
        mDao.insertAll(SampleData.getNotes());
        NoteEntity original = SampleData.getNotes().get(1);
        NoteEntity fromDb = mDao.getNoteById(2);
        Log.i(TAG,"compareStrings");
        assertEquals(original.getText(), fromDb.getText());
        assertEquals(2, fromDb.getId());
    }*/
}
