package com.renarosantos.ecommerceapp.di

import android.content.Context
import androidx.room.Room
import com.renarosantos.ecommerceapp.data.database.AppDatabase
import com.renarosantos.ecommerceapp.data.database.dao.WishlistDAO
import com.renarosantos.ecommerceapp.data.database.repository.WishlistDatabaseRepository
import com.renarosantos.ecommerceapp.data.repository.api.ApiClient
import com.renarosantos.ecommerceapp.data.repository.ProductRepository
import com.renarosantos.ecommerceapp.data.repository.WishlistRepository
import com.renarosantos.ecommerceapp.data.repository.api.ProductRepositoryAPI
import com.renarosantos.ecommerceapp.data.repository.api.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesProductService(): ProductService = ApiClient.getService()

    @Provides
    fun providedsProductRepositoryAPI(
        service: ProductService
    ): ProductRepositoryAPI = ProductRepositoryAPI(service)

    @Provides
    fun providesProductRepository(
        productRepositoryAPI: ProductRepositoryAPI
    ): ProductRepository = productRepositoryAPI

    @Provides
    fun providesWishlistRepository(
        databaseRepository: WishlistDatabaseRepository
    ) : WishlistRepository = databaseRepository

//    @Provides
//    fun providesWishlistDatabaseRepository(
//        wishlistDAO: WishlistDAO
//    ) : WishlistDatabaseRepository = WishlistDatabaseRepository(wishlistDAO)

    @Provides
    fun providesWishlistDatabaseRepository(wishlistDAO: WishlistDAO): WishlistDatabaseRepository {
        return WishlistDatabaseRepository(wishlistDAO)
    }

    @Provides
    fun providesWishlistDAO(@ApplicationContext context: Context): WishlistDAO {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "ecommerce"
        ).build()

        return db.wishlistDao()
    }

}