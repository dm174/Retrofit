package ru.netology.nmedia.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.netology.nmedia.api.PostApiServiceHolder
import ru.netology.nmedia.dto.Post

class PostRepositoryImpl : PostRepository {

    override fun getAllAsync(callback: PostRepository.Callback<List<Post>>) {
        PostApiServiceHolder.service.getAll()
            .enqueue(object : Callback<List<Post>> {
                override fun onResponse(
                    call: Call<List<Post>>,
                    response: Response<List<Post>>
                ) {
                    if (!response.isSuccessful) {
                        callback.onError(RuntimeException(response.message()))
                        return
                    }

                    callback.onSuccess(response.body() ?: run {
                        callback.onError(
                            RuntimeException(
                                response.message() + response.code().toString()
                            )
                        )
                        return
                    })
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    callback.onError(RuntimeException(t))
                }
            })
    }

    override fun likeByIdAsync(
        id: Long,
        callback: PostRepository.Callback<Post>
    ) {
        PostApiServiceHolder.service.likeById(id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (!response.isSuccessful) {
                    callback.onError(RuntimeException(response.message()))
                    return
                }

                callback.onSuccess(response.body() ?: run {
                    callback.onError(
                        RuntimeException(
                            response.message() + response.code().toString()
                        )
                    )
                    return
                })
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                callback.onError(RuntimeException(t))
            }
        })
    }

    override fun unlikeByIdAsync(
        id: Long,
        callback: PostRepository.Callback<Post>
    ) {
        PostApiServiceHolder.service.unlikeById(id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (!response.isSuccessful) {
                    callback.onError(RuntimeException(response.message()))
                    return
                }

                callback.onSuccess(response.body() ?: run {
                    callback.onError(
                        RuntimeException(
                            response.message() + response.code().toString()
                        )
                    )
                    return
                })
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                callback.onError(RuntimeException(t))
            }
        })
    }

    override fun saveAsync(
        post: Post,
        callback: PostRepository.Callback<Post>
    ) {
        PostApiServiceHolder.service.save(post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (!response.isSuccessful) {
                    callback.onError(RuntimeException(response.message()))
                    return
                }

                callback.onSuccess(response.body() ?: run {
                    callback.onError(
                        RuntimeException(
                            response.message() + response.code().toString()
                        )
                    )
                    return
                })
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                callback.onError(RuntimeException(t))
            }
        })
    }

    override fun removeByIdAsync(
        id: Long,
        callback: PostRepository.Callback<Unit>
    ) {
        PostApiServiceHolder.service.removeById(id).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (!response.isSuccessful) {
                    callback.onError(RuntimeException(response.message()))
                    return
                }

                callback.onSuccess(response.body() ?: run {
                    callback.onError(
                        RuntimeException(
                            response.message() + response.code().toString()
                        )
                    )
                    return
                })
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                callback.onError(RuntimeException(t))
            }
        })
    }
}