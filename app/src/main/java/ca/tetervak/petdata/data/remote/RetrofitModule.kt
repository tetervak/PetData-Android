package ca.tetervak.petdata.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val baseUrl =
        "https://tetervak.dev.fast.sheridanc.on.ca/mobile-app-data/pet-data/data/"

    @Provides
    @Singleton
    fun retrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun petDataApi(retrofit: Retrofit): PetDataApi =
        retrofit.create(PetDataApi::class.java)

}