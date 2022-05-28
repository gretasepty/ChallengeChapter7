package binar.greta.challengechapter7.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class FilmDBTest : TestCase(){

    private lateinit var db : FilmDB
    private lateinit var dao : DaoFilm

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, FilmDB::class.java).build()
        dao = db.daoFilm()
    }

    @After
    public override fun tearDown() {
        db.close()
    }

    @Test
    fun testData(){
        val result = dao.getFavorite()
    }
}