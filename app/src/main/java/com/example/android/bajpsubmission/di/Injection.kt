package com.example.android.bajpsubmission.di

// object Injection {
//
//     fun provideRepository(context: Context): AppRepository {
//
//         val remoteDataSource = RemoteDataSource.getInstance(ApiService.create())
//         val database = AppDatabase.getInstance(context)
//         val localDataSource = LocalDataSource.getInstance(database.appDao)
//
//         return AppRepository.getInstance(remoteDataSource, localDataSource)
//     }
// }