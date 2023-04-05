package com.example.ptms

class Model{
    private var title: String? = null
    private var image: Int? = null

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getImage(): Int? {
        return image
    }

    fun setImage(image: Int) {
        this.image = image
    }
}