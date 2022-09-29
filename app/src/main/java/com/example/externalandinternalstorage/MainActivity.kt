package com.example.externalandinternalstorage

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //External Storage
       /* var extStorageState = Environment.getExternalStorageState()
        if(extStorageState.equals(Environment.MEDIA_MOUNTED)){
            mt("This is media mounted storage - read & write access")
            Log.e("tag","Media Mounted")
        }
        if(extStorageState.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            mt("This is media mounted read only storage")
        }

        var rootDir : File = Environment.getExternalStorageDirectory()
        mt("Root Directory is : ${rootDir.absolutePath}")
        Log.e("tag","${rootDir.absolutePath}")

        var extMoviesRootDir : File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
        mt("Movies Root Dir is : ${rootDir.absolutePath}")
        Log.e("tag","${extMoviesRootDir.absolutePath}")

        var extMusicRootDir : File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        mt("Music Root Dir is : ${extMusicRootDir.absolutePath}")
        Log.e("tag","${extMusicRootDir.absolutePath}")

        var extAppRootDir = getExternalFilesDir(Environment.DIRECTORY_MOVIES)
        mt("External Storage ${extAppRootDir?.absolutePath}")
        Log.e("tag","${extAppRootDir?.absolutePath}")

        */


        //Internal Storage
        var fileOutputStream : FileOutputStream = openFileOutput("android_testFile",Activity.MODE_PRIVATE)
        fileOutputStream.write("Appreciated 3 girls of Android!".toByteArray())
        fileOutputStream.write("We are learning Android & Enjoying!".toByteArray())
        fileOutputStream.close()

        var fileInputStream : FileInputStream = openFileInput("android_testFile")
        var count = 0
        var data = ByteArray(1024 * 2)
        count = fileInputStream.read(data)

        while(count != -1){
            Log.e("tag",String(data,0,count))
            count = fileInputStream.read(data)
        }

        fileInputStream.close()
    }

    private fun mt(text : String){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }
}